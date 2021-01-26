package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusWalletAPI {

    @JsonRpcMethod(value = "Filecoin.WalletBalance", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<BigInteger> balance(String address);
}
