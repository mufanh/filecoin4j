package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.MessageSendSpec;
import com.github.mufanh.filecoin4j.domain.SignedMessage;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.Message;
import com.github.mufanh.filecoin4j.domain.types.MpoolConfig;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.JsonRpcParamsMode;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcMethod;
import com.github.mufanh.jsonrpc4j.annotation.JsonRpcService;

import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonRpcService
public interface LotusMpoolAPI {

    @JsonRpcMethod(value = "Filecoin.MpoolGetNonce", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<Long> getNonce(String address);

    @JsonRpcMethod(value = "Filecoin.MpoolPending", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<List<SignedMessage>> pending(TipSetKey tsk);

    @JsonRpcMethod(value = "Filecoin.MpoolSelect")
    Call<List<SignedMessage>> select(TipSetKey tsk, double tq);

    @JsonRpcMethod(value = "Filecoin.MpoolPush", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<Cid> push(SignedMessage message);

    @JsonRpcMethod(value = "Filecoin.MpoolPushUntrusted", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<Cid> pushUntrusted(SignedMessage message);

    @JsonRpcMethod(value = "Filecoin.MpoolPushMessage")
    Call<SignedMessage> pushMessage(Message message, MessageSendSpec spec);

    @JsonRpcMethod(value = "Filecoin.MpoolBatchPush")
    Call<List<Cid>> batchPush(List<SignedMessage> messages);

    @JsonRpcMethod(value = "Filecoin.MpoolBatchPushUntrusted")
    Call<List<Cid>> batchPushUntrusted(List<SignedMessage> messages);

    @JsonRpcMethod(value = "Filecoin.MpoolBatchPushMessage")
    Call<List<SignedMessage>> batchPushMessage(List<Message> messages, MessageSendSpec spec);

    @JsonRpcMethod(value = "Filecoin.MpoolClear", paramsPassMode = JsonRpcParamsMode.ARRAY)
    Call<Void> clear(boolean flag);

    @JsonRpcMethod(value = "Filecoin.MpoolGetConfig")
    Call<MpoolConfig> getConfig();

    @JsonRpcMethod(value = "Filecoin.MpoolSetConfig")
    Call<Void> setConfig(MpoolConfig config);
}
