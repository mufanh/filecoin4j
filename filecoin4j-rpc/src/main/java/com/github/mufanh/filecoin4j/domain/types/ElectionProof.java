package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class ElectionProof implements Serializable {

    private Long winCount;

    private String vRFProof;
}
