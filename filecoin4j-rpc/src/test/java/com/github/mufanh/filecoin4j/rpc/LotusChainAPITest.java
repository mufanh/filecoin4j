package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.BlockHeader;
import com.github.mufanh.filecoin4j.domain.Cid;
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
    public void head() throws IOException {
        Response<TipSet> response = lotusChainAPI.head().execute();
        TipSet result = response.getResult();
        System.out.println(JSONUtils.toJSONString(result));
    }

    @Test
    public void asyncHead() throws IOException {
        lotusChainAPI.head().enqueue(new Callback<TipSet>() {
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

    @Test
    public void getBlock() throws IOException {
        Cid cid = new Cid();
        cid.setId("bafy2bzacecw2iqzbduscwk3pywnmkyq62izcpas32ovcnhkdvjd2athk3ebhg");

        Response<BlockHeader> response = lotusChainAPI.getBlock(cid).execute();
        BlockHeader result = response.getResult();
        System.out.println(JSONUtils.toJSONString(result));
    }
}