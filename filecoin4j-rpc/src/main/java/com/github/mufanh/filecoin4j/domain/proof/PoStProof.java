package com.github.mufanh.filecoin4j.domain.proof;

import com.github.mufanh.filecoin4j.domain.abi.RegisteredPoStProof;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class PoStProof implements Serializable {

    private RegisteredPoStProof poStProof;

    private String proofBytes;
}
