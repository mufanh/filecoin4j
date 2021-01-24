package com.github.mufanh.filecoin4j.domain.builtin;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class SectorInfo implements Serializable {

    private long sealProof;

    private long sectorNumber;

    private Cid sealedCID;
}
