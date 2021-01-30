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

    private BigInteger value;

    private Long gasLimit;

    private BigInteger gasFeeCap;

    private BigInteger gasPremium;

    private Long method;

    private String params;

    @JsonProperty("CID")
    private Cid cid;
}
