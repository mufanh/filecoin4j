package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.SyncState;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xinquan.huangxq
 */
public class LotusSyncAPITest extends AbstractLotusAPITest {

    private final LotusSyncAPI lotusSyncAPI = lotusAPIFactory.createLotusSyncAPI();

    @Test
    public void state() throws IOException {
        Response<SyncState> response = lotusSyncAPI.state().execute();
        Assert.assertNotNull(response.getResult());
    }
}