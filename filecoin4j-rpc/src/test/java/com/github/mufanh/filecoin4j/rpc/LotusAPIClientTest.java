package com.github.mufanh.filecoin4j.rpc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.mufanh.filecoin4j.domain.TipSet;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author xinquan.huangxq
 */
public class LotusAPIClientTest {

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(MapperFeature.USE_STD_BEAN_NAMING, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    private static final String API_GATEWAY = "http://192.168.77.252:1234/rpc/v0";
    private static final String AUTHORIZATION = "";

    private static final LotusAPI lotusAPI = LotusAPIClient.of(API_GATEWAY, AUTHORIZATION);

    @Test
    public void chainHead() throws IOException {
        Response<TipSet> response = lotusAPI.chainHead().execute();
        TipSet result = response.getResult();
        System.out.println(mapper.writeValueAsString(result));
    }
}