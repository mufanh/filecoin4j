package com.github.mufanh.filecoin4j.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.mufanh.filecoin4j.domain.TipSet;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Callback;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.ResultSet;

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

    @Test
    public void asyncChainHead() throws IOException {
        lotusAPI.chainHead().enqueue(new Callback<TipSet>() {
            @Override
            public void onResponse(Call<TipSet> call, Response<TipSet> response) {
                try {
                    System.out.println(mapper.writeValueAsString(response.getResult()));
                } catch (JsonProcessingException e) {
                    e.printStackTrace(System.err);
                }
            }

            @Override
            public void onFailure(Call<TipSet> call, Throwable t) {
                t.printStackTrace(System.err);
            }
        });
    }
}