package com.github.mufanh.filecoin4j.domain;


import com.github.mufanh.filecoin4j.domain.builtin.Claim;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class MinerPower implements Serializable {

    private Claim minerPower;

    private Claim totalPower;

    private Boolean hasMinPower;
}
