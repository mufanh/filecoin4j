package com.github.mufanh.filecoin4j.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.mufanh.jsonrpc4j.JsonBodyConverter;
import com.github.mufanh.jsonrpc4j.JsonRpcRequest;
import com.github.mufanh.jsonrpc4j.JsonRpcResponse;
import com.github.mufanh.jsonrpc4j.JsonRpcRetrofit;
import okhttp3.Headers;

/**
 * @author xinquan.huangxq
 */
public class LotusAPIFactory {

    private static final String HEADER_AUTHORIZATION = "AUTHORIZATION";

    private final JsonRpcRetrofit jsonRpcRetrofit;

    private LotusAPIFactory(String apiGateway, String authorization) {
        this.jsonRpcRetrofit = new JsonRpcRetrofit.Builder()
                .httpUrl(apiGateway)
                .jsonBodyConverter(new JsonBodyConverter() {
                    @Override
                    public String convertRequest(JsonRpcRequest request) {
                        return LotusJSONUtils.toJSONString(request);
                    }

                    @Override
                    public <T> JsonRpcResponse<T> convertResponse(String response) {
                        return LotusJSONUtils.parseJSONObject(response, new TypeReference<JsonRpcResponse<T>>() {
                        });
                    }
                })
                .headers(Headers.of(HEADER_AUTHORIZATION, authorization))
                .build();
    }

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

    static class LotusJSONUtils {

        private static final ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.USE_STD_BEAN_NAMING, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);

        private LotusJSONUtils() {
            throw new AssertionError("Cannot be instantiated");
        }

        /**
         * 将对象转换为json字符串，若转换异常，则返回null
         *
         * @param object
         * @return
         */
        public static String toJSONString(Object object) {
            try {
                return mapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                return null;
            }
        }

        /**
         * 将json字符串转换为指定对象，若转换异常，则返回null
         *
         * @param json
         * @param type
         * @param <T>
         * @return
         */
        public static <T> T parseJSONObject(String json, TypeReference<T> type) {
            try {
                return mapper.readValue(json, type);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }
}
