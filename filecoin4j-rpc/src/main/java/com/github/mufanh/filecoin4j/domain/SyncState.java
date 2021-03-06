package com.github.mufanh.filecoin4j.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class SyncState implements Serializable {

    private List<ActiveSyncs> activeSyncs;

    private Long vMApplied;
}
