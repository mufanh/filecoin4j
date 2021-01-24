package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class MessageReceipt implements Serializable {

    private long exitCode;

    @JsonProperty("Return")
    private String ret;

    private BigInteger gasUsed;
}
