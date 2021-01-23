package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.TipSet;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusAPI {

    @JsonRpcMethod("Filecoin.ChainHead")
    Call<TipSet> chainHead();
}
