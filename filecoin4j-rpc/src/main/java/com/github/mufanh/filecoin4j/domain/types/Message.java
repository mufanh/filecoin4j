package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
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

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long version;

    private String to;

    private String from;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long nonce;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger value;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger gasLimit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger gasFeeCap;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigInteger gasPremium;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long method;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String params;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("CID")
    private Cid cid;
}
