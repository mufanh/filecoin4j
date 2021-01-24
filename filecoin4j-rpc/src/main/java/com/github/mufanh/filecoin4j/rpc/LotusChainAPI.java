package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.*;
import com.github.mufanh.filecoin4j.domain.Message;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.*;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsPassMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusChainAPI {

    @JsonRpcMethod("Filecoin.ChainHead")
    Call<TipSet> head();

    @JsonRpcMethod(value = "Filecoin.ChainGetBlock", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<BlockHeader> getBlock(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetTipSet", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<TipSet> getTipSet(TipSetKey tsk);

    @JsonRpcMethod(value = "Filecoin.ChainGetBlockMessages", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<BlockMessages> getBlockMessages(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetParentReceipts", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<List<MessageReceipt>> getParentReceipts(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetParentMessages", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<List<Message>> getParentMessages(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetMessage", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<com.github.mufanh.filecoin4j.domain.types.Message> getMessage(Cid cid);
}
