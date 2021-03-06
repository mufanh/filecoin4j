package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MessageSendSpec;
import com.github.mufanh.filecoin4j.domain.types.Message;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusGasAPI {

    @JsonRpcMethod("Filecoin.GasEstimateFeeCap")
    Call<BigInteger> estimateFeeCap(Message message, Long maxqueueblks, TipSetKey tsk);

    @JsonRpcMethod("Filecoin.GasEstimateGasLimit")
    Call<Long> estimateGasLimit(Message message, TipSetKey tsk);

    @JsonRpcMethod("Filecoin.GasEstimateGasPremium")
    Call<BigInteger> estimateGasPremium(Long nblocksincl, String sender, Long gaslimit, TipSetKey tsk);

    @JsonRpcMethod("Filecoin.GasEstimateMessageGas")
    Call<Message> estimateMessageGas(Message message, MessageSendSpec messageSendSpec, TipSetKey tsk);
}
