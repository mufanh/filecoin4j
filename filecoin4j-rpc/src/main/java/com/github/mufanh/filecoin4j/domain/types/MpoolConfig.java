package com.github.mufanh.filecoin4j.domain.types;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class MpoolConfig implements Serializable {

    private List<String> priorityAddrs;

    private Integer sizeLimitHigh;

    private Integer sizeLimitLow;

    private Double replaceByFeeRatio;

    /**
     * 单位：ns
     */
    private Long pruneCooldown;

    private Double gasLimitOverestimation;
}
