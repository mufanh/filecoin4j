package com.github.mufanh.filecoin4j.domain.proof;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class PoStProof implements Serializable {

    private Integer poStProof;

    private String proofBytes;
}
