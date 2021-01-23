package com.github.mufanh.filecoin4j.rpc;

/**
 * @author xinquan.huangxq
 */
public class AbstractLotusAPITest {

    private static final String API_GATEWAY = "http://192.168.77.252:1234/rpc/v0";
    private static final String AUTHORIZATION = "";

    protected LotusAPIFactory lotusAPIFactory = LotusAPIFactory.of(API_GATEWAY, AUTHORIZATION);
}