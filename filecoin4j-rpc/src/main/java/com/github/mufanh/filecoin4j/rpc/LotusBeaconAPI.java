package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.types.BeaconEntry;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusBeaconAPI {

    @JsonRpcMethod(value = "Filecoin.BeaconGetEntry", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<BeaconEntry> getEntry(long chainEpoch);
}
