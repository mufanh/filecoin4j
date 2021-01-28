package com.github.mufanh.filecoin4j.domain.abi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author xinquan.huangxq
 */
public enum RegisteredPoStProof {
    RegisteredPoStProof_StackedDrgWinning2KiBV1(0),
    RegisteredPoStProof_StackedDrgWinning8MiBV1(1),
    RegisteredPoStProof_StackedDrgWinning512MiBV1(2),
    RegisteredPoStProof_StackedDrgWinning32GiBV1(3),
    RegisteredPoStProof_StackedDrgWinning64GiBV1(4),

    RegisteredPoStProof_StackedDrgWindow2KiBV1(5),
    RegisteredPoStProof_StackedDrgWindow8MiBV1(6),
    RegisteredPoStProof_StackedDrgWindow512MiBV1(7),
    RegisteredPoStProof_StackedDrgWindow32GiBV1(8),
    RegisteredPoStProof_StackedDrgWindow64GiBV1(9),
    ;

    private final int code;

    RegisteredPoStProof(int code) {
        this.code = code;
    }

    @JsonCreator
    public static RegisteredPoStProof of(int code) {
        for (RegisteredPoStProof registeredPoStProof : RegisteredPoStProof.values()) {
            if (registeredPoStProof.code == code) {
                return registeredPoStProof;
            }
        }
        throw new IllegalArgumentException("Undefined RegisteredPoStProof code:" + code);
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
