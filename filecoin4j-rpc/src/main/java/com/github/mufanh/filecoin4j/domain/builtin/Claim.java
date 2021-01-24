package com.github.mufanh.filecoin4j.domain.builtin;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class Claim implements Serializable {

    // Sum of raw byte power for a miner's sectors.
    private long rawBytePower;

    // Sum of quality adjusted power for a miner's sectors.
    private long qualityAdjPower;
}
