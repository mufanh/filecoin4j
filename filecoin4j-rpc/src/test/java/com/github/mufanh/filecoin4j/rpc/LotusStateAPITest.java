package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MessageMatch;
import com.github.mufanh.filecoin4j.domain.MinerPower;
import com.github.mufanh.filecoin4j.domain.MsgLookup;
import com.github.mufanh.filecoin4j.domain.builtin.MinerInfo;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.Actor;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
public class LotusStateAPITest extends AbstractLotusAPITest {

    private final LotusStateAPI lotusStateAPI = lotusAPIFactory.createLotusStateAPI();

    @Test
    public void getActor() throws IOException {
        String address = "f065266";
        TipSetKey tsk = TipSetKey.of("bafy2bzacedssauumzfkfiohefymyrf7zc2mdotsu66vbvs7lgyjqhk3s5ro4g");

        Response<Actor> response = lotusStateAPI.getActor(address, tsk).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void minerInfo() throws IOException {
        String address = "f065266";
        TipSetKey tsk = TipSetKey.of("bafy2bzacedssauumzfkfiohefymyrf7zc2mdotsu66vbvs7lgyjqhk3s5ro4g");

        Response<MinerInfo> response = lotusStateAPI.minerInfo(address, tsk).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void minerPower() throws IOException {
        String address = "f065266";
        TipSetKey tsk = TipSetKey.of("bafy2bzacedssauumzfkfiohefymyrf7zc2mdotsu66vbvs7lgyjqhk3s5ro4g");

        Response<MinerPower> response = lotusStateAPI.minerPower(address, tsk).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void searchMsg() throws IOException {
        Cid cid = Cid.of("bafy2bzacedpbydb4invychu6edp7qzk3ygyy4ftneeaaikdvjsgseqyxh4pla");

        Response<MsgLookup> response = lotusStateAPI.searchMsg(cid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void listMessages() throws IOException {
        MessageMatch messageMatch = MessageMatch.of(
                "f3vqnpfuda5mjmmye5nhtsyljquv5gokaf6f2lrpmn7mx2qffw4h4gqxsk4yfq2wjvbn6jd37bvw5g4fe4nyra",
                "f0130791");

        Response<List<Cid>> response = lotusStateAPI.listMessages(messageMatch, null, 445113L).execute();
        Assert.assertNotNull(response.getResult());
    }
}