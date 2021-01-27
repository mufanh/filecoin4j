package com.github.mufanh.filecoin4j.domain.builtin;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class Claim implements Serializable {

    // Sum of raw byte power for a miner's sectors.
    private Long rawBytePower;

    // Sum of quality adjusted power for a miner's sectors.
    private Long qualityAdjPower;
}
