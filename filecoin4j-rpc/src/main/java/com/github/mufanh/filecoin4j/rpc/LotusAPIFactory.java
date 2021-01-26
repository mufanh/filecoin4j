package com.github.mufanh.filecoin4j.rpc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.github.mufanh.jsonrpc4j.*;
import okhttp3.Headers;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author xinquan.huangxq
 */
public class LotusAPIFactory {

    public static LotusAPIFactory of(String apiGateway, String authorization) {
        return new LotusAPIFactory(apiGateway, authorization);
    }

    public LotusChainAPI createLotusChainAPI() {
        return createLotusAPI(LotusChainAPI.class);
    }

    public LotusGasAPI createLotusGasAPI() {
        return createLotusAPI(LotusGasAPI.class);
    }

    public LotusMinerAPI createLotusMinerAPI() {
        return createLotusAPI(LotusMinerAPI.class);
    }

    public LotusStateAPI createLotusStateAPI() {
        return createLotusAPI(LotusStateAPI.class);
    }

    public LotusSyncAPI createLotusSyncAPI() {
        return createLotusAPI(LotusSyncAPI.class);
    }

    public LotusWalletAPI createLotusWalletAPI() {
        return createLotusAPI(LotusWalletAPI.class);
    }

    public LotusMpoolAPI createLotusMPoolAPI() {
        return createLotusAPI(LotusMpoolAPI.class);
    }

    private <T> T createLotusAPI(Class<T> apiClass) {
        return jsonRpcRetrofit.create(apiClass);
    }

    private static final String HEADER_AUTHORIZATION = "AUTHORIZATION";

    private final JsonRpcRetrofit jsonRpcRetrofit;

    private LotusAPIFactory(String apiGateway, String authorization) {
        this.jsonRpcRetrofit = new JsonRpcRetrofit.Builder()
                .httpUrl(apiGateway)
                .jsonBodyConverter(new LotusJsonBodyConverter())
                .headers(Headers.of(HEADER_AUTHORIZATION, authorization))
                .build();
    }

    private static class LotusJsonBodyConverter implements JsonBodyConverter {

        private static final ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.USE_STD_BEAN_NAMING, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);

        @Override
        public String convertRequest(JsonRpcRequest request) throws JsonConvertException {
            try {
                return mapper.writeValueAsString(request);
            } catch (JsonProcessingException e) {
                throw new JsonConvertException("JSON-RPC request convert error.", e);
            }
        }

        @Override
        public <T> JsonRpcResponse<T> convertResponse(Type type, String response) throws JsonConvertException {
            try {
                JsonRpcResponse<T> jsonRpcResponse = new JsonRpcResponse<>();

                JsonNode jsonNode = mapper.readTree(response);
                if (jsonNode == null) {
                    return jsonRpcResponse;
                }

                JsonNode id = jsonNode.get("id");
                if (id != null) {
                    jsonRpcResponse.setId(id.asLong());
                }

                JsonNode jsonrpc = jsonNode.get("jsonrpc");
                if (jsonrpc != null) {
                    jsonRpcResponse.setJsonrpc(jsonrpc.asText());
                }

                jsonRpcResponse.setError(parseJsonNode(jsonNode.get("error"), JsonRpcResponse.Error.class));
                jsonRpcResponse.setResult(parseJsonNode(jsonNode.get("result"), type));
                return jsonRpcResponse;
            } catch (Exception e) {
                throw new JsonConvertException("JSON-RPC response convert error.", e);
            }
        }

        private static <T> T parseJsonNode(JsonNode jsonNode, Type type) throws IOException {
            if (jsonNode == null) {
                return null;
            }
            JsonParser parser = mapper.treeAsTokens(jsonNode);
            JavaType javaType = mapper.getTypeFactory().constructType(type);
            return mapper.readValue(parser, javaType);
        }
    }

}
