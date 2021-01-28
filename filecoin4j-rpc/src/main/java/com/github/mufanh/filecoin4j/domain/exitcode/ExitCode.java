package com.github.mufanh.filecoin4j.domain.exitcode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author xinquan.huangxq
 */
public enum ExitCode {
    Ok(0),
    SysErrSenderInvalid(1),
    SysErrSenderStateInvalid(2),
    SysErrInvalidMethod(3),
    SysErrReserved1(4),
    SysErrInvalidReceiver(5),
    SysErrInsufficientFunds(6),
    SysErrOutOfGas(7),
    SysErrForbidden(8),
    SysErrorIllegalActor(9),
    SysErrorIllegalArgument(10),

    // Unused
    SysErrReserved2(11),
    SysErrReserved3(12),
    SysErrReserved4(13),
    SysErrReserved5(14),
    SysErrReserved6(15),
    ;

    private final int code;

    ExitCode(int code) {
        this.code = code;
    }

    @JsonCreator
    public static ExitCode of(int code) {
        for (ExitCode exitCode : ExitCode.values()) {
            if (exitCode.code == code) {
                return exitCode;
            }
        }
        throw new IllegalArgumentException("Undefined ExitCode code:" + code);
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
