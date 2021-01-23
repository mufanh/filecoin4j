package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.TipSet;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Callback;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xinquan.huangxq
 */
public class LotusChainAPITest extends AbstractLotusAPITest {

    private final LotusChainAPI lotusChainAPI = lotusAPIFactory.createLotusChainAPI();

    @Test
    public void chainHead() throws IOException {
        Response<TipSet> response = lotusChainAPI.chainHead().execute();
        TipSet result = response.getResult();
        System.out.println(JSONUtils.toJSONString(result));
    }

    @Test
    public void asyncChainHead() throws IOException {
        lotusChainAPI.chainHead().enqueue(new Callback<TipSet>() {
            @Override
            public void onResponse(Call<TipSet> call, Response<TipSet> response) {
                System.out.println(JSONUtils.toJSONString(response.getResult()));
            }

            @Override
            public void onFailure(Call<TipSet> call, Throwable t) {
                t.printStackTrace(System.err);
            }
        });
    }
}