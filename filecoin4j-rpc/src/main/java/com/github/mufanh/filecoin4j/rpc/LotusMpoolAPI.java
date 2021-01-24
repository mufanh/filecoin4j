package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.SignedMessage;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsPassMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusMpoolAPI {

    @JsonRpcMethod(value = "Filecoin.MpoolGetNonce", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<Long> getNonce(String address);

    @JsonRpcMethod(value = "Filecoin.MpoolPush", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<Cid> push(SignedMessage message);
}
