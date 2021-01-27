package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.types.BeaconEntry;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author xinquan.huangxq
 */
public class LotusBeaconAPITest extends AbstractLotusAPITest {

    private final LotusBeaconAPI lotusBeaconAPI = lotusAPIFactory.createLotusBeaconAPI();

    @Test
    public void getEntry() throws IOException {
        Response<BeaconEntry> response = lotusBeaconAPI.getEntry(445113L).execute();
        Assert.assertNotNull(response.getResult());
    }
}