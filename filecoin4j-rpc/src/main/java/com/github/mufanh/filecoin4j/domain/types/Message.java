package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@Data
public class Message implements Serializable {

    private Long version;

    private String to;

    private String from;

    private Long nonce;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger value;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger gasLimit;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger gasFeeCap;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger gasPremium;

    private Long method;

    private String params;

    @JsonProperty("CID")
    private Cid cid;
}
