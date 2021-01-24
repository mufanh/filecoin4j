package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MinerPower;
import com.github.mufanh.filecoin4j.domain.MsgLookup;
import com.github.mufanh.filecoin4j.domain.builtin.MinerInfo;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.Actor;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Test;

import java.io.IOException;

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
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void minerInfo() throws IOException {
        String address = "f065266";
        TipSetKey tsk = TipSetKey.of("bafy2bzacedssauumzfkfiohefymyrf7zc2mdotsu66vbvs7lgyjqhk3s5ro4g");

        Response<MinerInfo> response = lotusStateAPI.minerInfo(address, tsk).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void minerPower() throws IOException {
        String address = "f065266";
        TipSetKey tsk = TipSetKey.of("bafy2bzacedssauumzfkfiohefymyrf7zc2mdotsu66vbvs7lgyjqhk3s5ro4g");

        Response<MinerPower> response = lotusStateAPI.minerPower(address, tsk).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }

    @Test
    public void searchMsg() throws IOException {
        Cid cid = Cid.of("bafy2bzacebtavrtw2gas3oep642zmtxntm6vlal2iaqfoxeheencfjccaohn2");

        Response<MsgLookup> response = lotusStateAPI.searchMsg(cid).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }
}