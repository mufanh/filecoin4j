package com.github.mufanh.filecoin4j.rpc;

/**
 * @author xinquan.huangxq
 */
public class AbstractLotusAPITest {

    private static final String API_ROUTER = "https://1mPFsTLsLORQ38w5qLhBNMwJ1pz:7288a96f1a57d28747b299e3b87ed120@filecoin.infura.io";
    private static final String AUTHORIZATION = "Basic MW1QRnNUTHNMT1JRMzh3NXFMaEJOTXdKMXB6OjcyODhhOTZmMWE1N2QyODc0N2IyOTllM2I4N2VkMTIw";
    //private static final String API_ROUTER = "http://192.168.77.252:1234/rpc/v0";
    //private static final String AUTHORIZATION = "";

    protected LotusAPIFactory lotusAPIFactory = new LotusAPIFactory.Builder()
            .apiGateway(API_ROUTER)
            .authorization(AUTHORIZATION)
            .connectTimeout(5)
            .readTimeout(60)
            .writeTimeout(30)
            .build();
}
