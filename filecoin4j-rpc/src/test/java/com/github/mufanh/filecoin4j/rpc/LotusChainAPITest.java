package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.*;
import com.github.mufanh.filecoin4j.domain.Message;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.*;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Callback;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
public class LotusChainAPITest extends AbstractLotusAPITest {

    private final LotusChainAPI lotusChainAPI = lotusAPIFactory.createLotusChainAPI();

    @Test
    public void head() throws IOException {
        Response<TipSet> response = lotusChainAPI.head().execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
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
        cid.setStr("bafy2bzacecw2iqzbduscwk3pywnmkyq62izcpas32ovcnhkdvjd2athk3ebhg");

        Response<BlockHeader> response = lotusChainAPI.getBlock(cid).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void getTipSet() throws IOException {
        TipSetKey tipSetKey = new TipSetKey();

        Cid cid = new Cid();
        cid.setStr("bafy2bzacec2s3vifae4es5sc7zcbdqd2ckig6c77qaovter4uniiskn2ngx3k");
        tipSetKey.add(cid);

        Response<TipSet> response = lotusChainAPI.getTipSet(tipSetKey).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void getBlockMessages() throws IOException {
        Cid cid = new Cid();
        cid.setStr("bafy2bzacecw2iqzbduscwk3pywnmkyq62izcpas32ovcnhkdvjd2athk3ebhg");

        Response<BlockMessages> response = lotusChainAPI.getBlockMessages(cid).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void getParentReceipts() throws IOException {
        Cid cid = new Cid();
        cid.setStr("bafy2bzacecw2iqzbduscwk3pywnmkyq62izcpas32ovcnhkdvjd2athk3ebhg");

        Response<List<MessageReceipt>> response = lotusChainAPI.getParentReceipts(cid).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void getParentMessages() throws IOException {
        Cid cid = new Cid();
        cid.setStr("bafy2bzacecw2iqzbduscwk3pywnmkyq62izcpas32ovcnhkdvjd2athk3ebhg");

        Response<List<Message>> response = lotusChainAPI.getParentMessages(cid).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void getMessage() throws IOException {
        Cid cid = new Cid();
        cid.setStr("bafy2bzacebgzuqqkjtgauyg5f4wdgnovlyfzrlc67fjjmgxontek3unpu2fse");

        Response<com.github.mufanh.filecoin4j.domain.types.Message> response = lotusChainAPI.getMessage(cid).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }
}