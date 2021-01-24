package com.github.mufanh.filecoin4j.rpc;

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

    private <T> T createLotusAPI(Class<T> apiClass) {
        return jsonRpcRetrofit.create(apiClass);
    }
}
