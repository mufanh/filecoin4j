package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MessageSendSpec;
import com.github.mufanh.filecoin4j.domain.types.Message;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
public class LotusGasAPITest extends LotusChainAPITest {

    private final LotusGasAPI lotusGasAPI = lotusAPIFactory.createLotusGasAPI();

    @Test
    public void estimateFeeCap() throws IOException {
    }

    @Test
    public void estimateGasLimit() {
    }

    @Test
    public void estimateGasPremium() {
    }

    @Test
    public void estimateMessageGas() throws IOException {
        Message message = new Message();
        message.setFrom("f1rfw5ln22fw63llzqyhjrgmx572j5hquyvymmrpq");
        message.setTo("f15baz6uoufdyfodaay4gky4pz6oo5rrpab6yt7pa");
        message.setValue(new BigInteger("100000000000000"));

        MessageSendSpec messageSendSpec = null;

        TipSetKey tsk = null;

        Response<Message> response = lotusGasAPI.estimateMessageGas(message, messageSendSpec, tsk).execute();
    }
}