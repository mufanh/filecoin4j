package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.*;
import com.github.mufanh.filecoin4j.domain.Message;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.*;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusChainAPI {

    @JsonRpcMethod("Filecoin.ChainHead")
    Call<TipSet> head();

    @JsonRpcMethod("Filecoin.ChainGetGenesis")
    Call<TipSet> getGenesis();

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

    @JsonRpcMethod(value = "Filecoin.ChainGetTipSetByHeight")
    Call<TipSet> getTipSetByHeight(Long chainEpoch, TipSetKey tsk);

    @JsonRpcMethod(value = "Filecoin.ChainHasObj", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<Boolean> hasObj(Cid cid);

    @JsonRpcMethod(value = "Filecoin.ChainReadObj", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<String> readObj(Cid cid);

    @JsonRpcMethod(value = "Filecoin.ChainDeleteObj", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<Void> deleteObj(Cid cid);

    @JsonRpcMethod(value = "Filecoin.ChainStatObj")
    Call<Void> statObj(Cid objectCid, Cid baseCid);

    @JsonRpcMethod(value = "Filecoin.ChainTipSetWeight", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<BigInteger> tipSetWeight(TipSetKey tsk);
}
