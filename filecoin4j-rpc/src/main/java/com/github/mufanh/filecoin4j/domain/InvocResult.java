package com.github.mufanh.filecoin4j.domain;

import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.ExecutionTrace;
import com.github.mufanh.filecoin4j.domain.types.Message;
import com.github.mufanh.filecoin4j.domain.types.MessageReceipt;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class InvocResult implements Serializable {

    private Cid msgCid;

    private Message msg;

    private MessageReceipt msgRct;

    private MsgGasCost gasCost;

    private ExecutionTrace executionTrace;

    private String error;

    private Long duration;
}
