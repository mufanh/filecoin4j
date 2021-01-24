package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MiningBaseInfo;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xinquan.huangxq
 */
public class LotusMinerAPITest extends AbstractLotusAPITest {

    private final LotusMinerAPI lotusMinerAPI = lotusAPIFactory.createLotusMinerAPI();

    @Test
    public void getBaseInfo() throws IOException {
        String address = "f065266";
        long chainEpoch = 438131L;
        TipSetKey tsk = TipSetKey.of("bafy2bzacedssauumzfkfiohefymyrf7zc2mdotsu66vbvs7lgyjqhk3s5ro4g");

        Response<MiningBaseInfo> response = lotusMinerAPI.getBaseInfo(address, chainEpoch, tsk).execute();
        System.out.println(JSONUtils.toJSONString(response.getResult()));
    }
}