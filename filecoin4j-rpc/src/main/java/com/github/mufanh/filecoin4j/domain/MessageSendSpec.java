package com.github.mufanh.filecoin4j.domain;


import lombok.Data;

import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@Data
public class MessageSendSpec {

    private BigInteger maxFee;
}
