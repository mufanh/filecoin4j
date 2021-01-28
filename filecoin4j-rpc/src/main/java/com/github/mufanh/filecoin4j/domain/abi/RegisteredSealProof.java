package com.github.mufanh.filecoin4j.domain.abi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author xinquan.huangxq
 */
public enum RegisteredSealProof {
    RegisteredSealProof_StackedDrg2KiBV1(0),
    RegisteredSealProof_StackedDrg8MiBV1(1),
    RegisteredSealProof_StackedDrg512MiBV1(2),
    RegisteredSealProof_StackedDrg32GiBV1(3),
    RegisteredSealProof_StackedDrg64GiBV1(4),

    RegisteredSealProof_StackedDrg2KiBV1_1(5),
    RegisteredSealProof_StackedDrg8MiBV1_1(6),
    RegisteredSealProof_StackedDrg512MiBV1_1(7),
    RegisteredSealProof_StackedDrg32GiBV1_1(8),
    RegisteredSealProof_StackedDrg64GiBV1_1(9),
    ;

    private final int code;

    RegisteredSealProof(int code) {
        this.code = code;
    }

    @JsonCreator
    public static RegisteredSealProof of(int code) {
        for (RegisteredSealProof registeredSealProof : RegisteredSealProof.values()) {
            if (registeredSealProof.code == code) {
                return registeredSealProof;
            }
        }
        throw new IllegalArgumentException("Undefined RegisteredSealProof code:" + code);
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
