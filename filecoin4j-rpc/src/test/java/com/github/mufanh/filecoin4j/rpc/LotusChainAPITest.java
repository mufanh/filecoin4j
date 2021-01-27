package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.*;
import com.github.mufanh.filecoin4j.domain.Message;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.*;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Callback;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author xinquan.huangxq
 */
public class LotusChainAPITest extends AbstractLotusAPITest {

    private final LotusChainAPI lotusChainAPI = lotusAPIFactory.createLotusChainAPI();

    @Test
    public void head() throws IOException {
        Response<TipSet> response = lotusChainAPI.head().execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void asyncHead() throws IOException, InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        lotusChainAPI.head().enqueue(new Callback<TipSet>() {
            @Override
            public void onResponse(Call<TipSet> call, Response<TipSet> response) {
                Assert.assertNotNull(response.getResult());

                cdl.countDown();
            }

            @Override
            public void onFailure(Call<TipSet> call, Throwable t) {
                t.printStackTrace(System.err);
            }
        });
        cdl.await();
    }

    @Test
    public void getGenesis() throws IOException {
        Response<TipSet> response = lotusChainAPI.getGenesis().execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getBlock() throws IOException {
        Response<BlockHeader> response = lotusChainAPI.getBlock(Cid.of("bafy2bzacechdndwv3k6zripfpxm4jtwdvqnzlp6uvldccwf6cycmd2w3elvfc")).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getTipSet() throws IOException {
        TipSetKey tipSetKey = TipSetKey.of("bafy2bzacec2qt5iuro25nmrt25amfb3lx6nebtdmdljodcuzen36lxrkjk2o4",
                "bafy2bzacecy5go5sxv7rgm5ncd5zkgwm43rhg7ko35rue5jh52jliym55ofrg",
                "bafy2bzacebkqspb5auphn5dxucsdmc7xsnj6pcxjhc7ivlxsla6oxlhniwkq6");

        Response<TipSet> response = lotusChainAPI.getTipSet(tipSetKey).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getBlockMessages() throws IOException {
        Cid blockCid = Cid.of("bafy2bzacechdndwv3k6zripfpxm4jtwdvqnzlp6uvldccwf6cycmd2w3elvfc");

        Response<BlockMessages> response = lotusChainAPI.getBlockMessages(blockCid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getParentReceipts() throws IOException {
        Cid blockCid = Cid.of("bafy2bzacechdndwv3k6zripfpxm4jtwdvqnzlp6uvldccwf6cycmd2w3elvfc");

        Response<List<MessageReceipt>> response = lotusChainAPI.getParentReceipts(blockCid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getParentMessages() throws IOException {
        Cid blockCid = Cid.of("bafy2bzacechdndwv3k6zripfpxm4jtwdvqnzlp6uvldccwf6cycmd2w3elvfc");

        Response<List<Message>> response = lotusChainAPI.getParentMessages(blockCid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getMessage() throws IOException {
        Cid cid = Cid.of("bafy2bzacebgzuqqkjtgauyg5f4wdgnovlyfzrlc67fjjmgxontek3unpu2fse");

        Response<com.github.mufanh.filecoin4j.domain.types.Message> response = lotusChainAPI.getMessage(cid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getTipSetByHeight() throws IOException {
        TipSetKey tsk = TipSetKey.of("bafy2bzacec2qt5iuro25nmrt25amfb3lx6nebtdmdljodcuzen36lxrkjk2o4",
                "bafy2bzacecy5go5sxv7rgm5ncd5zkgwm43rhg7ko35rue5jh52jliym55ofrg",
                "bafy2bzacebkqspb5auphn5dxucsdmc7xsnj6pcxjhc7ivlxsla6oxlhniwkq6");

        Response<TipSet> response1 = lotusChainAPI.getTipSetByHeight(445113L, tsk).execute();
        Assert.assertNotNull(response1.getResult());

        Response<TipSet> response2 = lotusChainAPI.getTipSetByHeight(445113L, null).execute();
        Assert.assertNotNull(response2.getResult());

        Response<TipSet> response3 = lotusChainAPI.getTipSetByHeight(null, tsk).execute();
        Assert.assertNotNull(response3.getResult());
    }
}