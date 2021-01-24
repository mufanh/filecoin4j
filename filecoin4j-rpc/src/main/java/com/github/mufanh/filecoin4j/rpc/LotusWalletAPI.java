package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsPassMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusWalletAPI {

    @JsonRpcMethod(value = "Filecoin.WalletBalance", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<BigInteger> balance(String address);
}
