package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.BlockHeader;
import com.github.mufanh.filecoin4j.domain.Cid;
import com.github.mufanh.filecoin4j.domain.TipSet;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsPassMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusChainAPI {

    @JsonRpcMethod("Filecoin.ChainHead")
    Call<TipSet> head();

    @JsonRpcMethod(value = "Filecoin.ChainGetBlock", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<BlockHeader> getBlock(Cid cid);
}
