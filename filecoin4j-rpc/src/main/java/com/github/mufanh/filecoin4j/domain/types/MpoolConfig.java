package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class MpoolConfig implements Serializable {

    private List<String> priorityAddrs;

    private Integer sizeLimitHigh;

    private Integer sizeLimitLow;

    private Double replaceByFeeRatio;

    private Long pruneCooldown;

    private Double gasLimitOverestimation;
}
