package com.github.mufanh.filecoin4j.domain.types;

import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@Data
public class Actor implements Serializable {

    private Cid code;

    private Cid head;

    private Long nonce;

    private BigInteger balance;
}
