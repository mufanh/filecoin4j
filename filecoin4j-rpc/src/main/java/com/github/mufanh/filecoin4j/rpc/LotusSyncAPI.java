package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.SyncState;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusSyncAPI {

    @JsonRpcMethod("Filecoin.SyncState")
    Call<SyncState> state();
}
