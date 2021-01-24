package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class Message implements Serializable {

    private long version;

    private String to;

    private String from;

    private long nonce;

    private BigInteger value;

    private BigInteger gasLimit;

    private BigInteger gasFeeCap;

    private BigInteger gasPremium;

    private long method;

    private String params;

    @JsonProperty("CID")
    private Cid cid;
}
