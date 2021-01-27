package com.github.mufanh.filecoin4j.domain.builtin;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class MinerInfo implements Serializable {

    private String owner;

    private String worker;

    private String newWorker;

    private List<String> controlAddresses;

    private Long workerChangeEpoch;

    private String peerId;

    private List<String> multiaddrs;

    private Long sealProofType;

    private Long sectorSize;

    private Long windowPoStPartitionSectors;

    private Long consensusFaultElapsed;
}
