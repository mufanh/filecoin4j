package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class SyncState implements Serializable {

    private List<ActiveSyncs> activeSyncs;

    private Long vMApplied;
}
