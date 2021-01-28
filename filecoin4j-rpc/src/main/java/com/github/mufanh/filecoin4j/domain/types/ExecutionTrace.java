package com.github.mufanh.filecoin4j.domain.types;

import com.github.mufanh.filecoin4j.domain.types.Message;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class ExecutionTrace implements Serializable {

    private Message msg;

    private MessageReceipt msgRct;

    private String error;

    private Long duration;

    private List<GasTrace> gasCharges;

    private List<ExecutionTrace> subcalls;
}
