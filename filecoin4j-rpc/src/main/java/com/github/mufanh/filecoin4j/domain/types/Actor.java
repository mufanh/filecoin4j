package com.github.mufanh.filecoin4j.domain.types;

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
public class Actor implements Serializable {

    private Cid code;

    private Cid head;

    private long nonce;

    private BigInteger balance;
}
