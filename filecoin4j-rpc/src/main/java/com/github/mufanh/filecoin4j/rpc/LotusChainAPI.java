package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.*;
import com.github.mufanh.filecoin4j.domain.Message;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.*;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsMode;
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

    @JsonRpcMethod(value = "Filecoin.ChainGetBlock", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<BlockHeader> getBlock(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetTipSet", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<TipSet> getTipSet(TipSetKey tsk);

    @JsonRpcMethod(value = "Filecoin.ChainGetBlockMessages", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<BlockMessages> getBlockMessages(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetParentReceipts", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<List<MessageReceipt>> getParentReceipts(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetParentMessages", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<List<Message>> getParentMessages(Cid blockCid);

    @JsonRpcMethod(value = "Filecoin.ChainGetMessage", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<com.github.mufanh.filecoin4j.domain.types.Message> getMessage(Cid cid);
}
