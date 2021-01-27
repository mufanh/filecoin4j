package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@Data
public class MessageReceipt implements Serializable {

    private Long exitCode;

    @JsonProperty("Return")
    private String ret;

    private BigInteger gasUsed;
}
