package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MiningBaseInfo;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusMinerAPI {

    @JsonRpcMethod("Filecoin.MinerGetBaseInfo")
    Call<MiningBaseInfo> getBaseInfo(String address, long chainEpoch, TipSetKey tsk);
}
