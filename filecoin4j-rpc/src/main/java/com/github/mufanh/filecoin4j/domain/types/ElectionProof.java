package com.github.mufanh.filecoin4j.domain.types;


import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class ElectionProof implements Serializable {

    private Long winCount;

    private String vRFProof;
}
