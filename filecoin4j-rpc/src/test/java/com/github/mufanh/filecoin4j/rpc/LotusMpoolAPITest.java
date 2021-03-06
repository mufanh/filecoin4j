package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xinquan.huangxq
 */
public class LotusMpoolAPITest extends AbstractLotusAPITest {

    private final LotusMpoolAPI lotusMPoolAPI = lotusAPIFactory.createLotusMPoolAPI();

    @Test
    public void getNonce() throws IOException {
        Response<Long> response = lotusMPoolAPI.getNonce("f1rfw5ln22fw63llzqyhjrgmx572j5hquyvymmrpq").execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void push() {
    }

    @Test
    public void testPush() {
    }

    @Test
    public void pending() {
    }
}