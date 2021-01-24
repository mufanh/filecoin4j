package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * @author xinquan.huangxq
 */
public class LotusWalletAPITest extends AbstractLotusAPITest {

    private final LotusWalletAPI lotusWalletAPI = lotusAPIFactory.createLotusWalletAPI();

    @Test
    public void balance() throws IOException {
        Response<BigInteger> response = lotusWalletAPI.balance("f1rfw5ln22fw63llzqyhjrgmx572j5hquyvymmrpq").execute();
        System.out.println(response.getResult());
    }
}