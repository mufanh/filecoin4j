package com.github.mufanh.filecoin4j.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@Data
public class ActorState implements Serializable {

    private BigInteger balance;

    // 	State   interface{}
    private Object state;
}
