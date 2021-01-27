package com.github.mufanh.filecoin4j.domain.builtin;

import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class SectorInfo implements Serializable {

    private Long sealProof;

    private Long sectorNumber;

    private Cid sealedCID;
}
