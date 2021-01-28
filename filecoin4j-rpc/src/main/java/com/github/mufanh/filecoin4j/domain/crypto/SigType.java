package com.github.mufanh.filecoin4j.domain.crypto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.mufanh.filecoin4j.domain.abi.RegisteredPoStProof;

/**
 * @author xinquan.huangxq
 */
public enum SigType {
    SigTypeSecp256k1(1),
    SigTypeBLS(2),

    SigTypeUnknown(1<<8 - 1)
    ;

    private final int code;

    SigType(int code) {
        this.code = code;
    }

    @JsonCreator
    public static SigType of(int code) {
        for (SigType sigType : SigType.values()) {
            if (sigType.code == code) {
                return sigType;
            }
        }
        throw new IllegalArgumentException("Undefined SigType code:" + code);
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
