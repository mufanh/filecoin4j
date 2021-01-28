package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author xinquan.huangxq
 */
public enum SyncStateStage {
    StageIdle(0),
    StageHeaders(1),
    StagePersistHeaders(2),
    StageMessages(3),
    StageSyncComplete(4),
    StageSyncErrored(5),
    StageFetchingMessages(6),
    ;

    private final int code;

    SyncStateStage(int code) {
        this.code = code;
    }

    @JsonCreator
    public static SyncStateStage of(int code) {
        for (SyncStateStage stage : SyncStateStage.values()) {
            if (stage.code == code) {
                return stage;
            }
        }
        throw new IllegalArgumentException("Undefined SyncStateStage code:" + code);
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
