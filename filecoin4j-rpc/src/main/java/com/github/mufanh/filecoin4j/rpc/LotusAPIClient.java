package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.TipSet;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcRetrofit;
import okhttp3.Headers;

/**
 * @author xinquan.huangxq
 */
public class LotusAPIClient implements LotusAPI {

    private static final String HEADER_AUTHORIZATION = "AUTHORIZATION";

    private final LotusAPI lotusAPIRpc;

    private LotusAPIClient(String apiGateway, String authorization) {
        JsonRpcRetrofit jsonRpcRetrofit = new JsonRpcRetrofit.Builder()
                .httpUrl(apiGateway)
                .headers(Headers.of(HEADER_AUTHORIZATION, authorization))
                .build();
        this.lotusAPIRpc = jsonRpcRetrofit.create(LotusAPI.class);
    }

    public static LotusAPIClient of(String apiGateway, String authorization) {
        return new LotusAPIClient(apiGateway, authorization);
    }

    @Override
    public Call<TipSet> chainHead() {
        return lotusAPIRpc.chainHead();
    }
}
