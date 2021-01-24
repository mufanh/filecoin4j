package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MinerPower;
import com.github.mufanh.filecoin4j.domain.MsgLookup;
import com.github.mufanh.filecoin4j.domain.builtin.MinerInfo;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.Actor;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsPassMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusStateAPI {

    @JsonRpcMethod("Filecoin.StateGetActor")
    Call<Actor> getActor(String address, TipSetKey tsk);

    @JsonRpcMethod("Filecoin.StateMinerInfo")
    Call<MinerInfo> minerInfo(String address, TipSetKey tsk);

    @JsonRpcMethod("Filecoin.StateMinerPower")
    Call<MinerPower> minerPower(String address, TipSetKey tsk);

    @JsonRpcMethod(value = "Filecoin.StateSearchMsg", paramsPassMode = JsonRpcParamsPassMode.ARRAY)
    Call<MsgLookup> searchMsg(Cid cid);
}
