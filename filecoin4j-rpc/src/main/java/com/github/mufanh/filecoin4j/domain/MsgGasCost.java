package com.github.mufanh.filecoin4j.domain;

import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author xinquan.huangxq
 */
@Data
public class MsgGasCost implements Serializable {

    private Cid message;

    private BigInteger gasUsed;

    private BigInteger baseFeeBurn;

    private BigInteger overEstimationBurn;

    private BigInteger minerPenalty;

    private BigInteger minerTip;

    private BigInteger refund;

    private BigInteger totalCost;
}
