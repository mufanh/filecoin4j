package com.github.mufanh.filecoin4j.domain.builtin;

import com.github.mufanh.filecoin4j.domain.abi.RegisteredSealProof;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class MinerInfo implements Serializable {

    private String minerId;

    private String owner;

    private String worker;

    private String newWorker;

    private List<String> controlAddresses;

    private Long workerChangeEpoch;

    private String peerId;

    private List<String> multiaddrs;

    private RegisteredSealProof sealProofType;

    private Long sectorSize;

    private Long windowPoStPartitionSectors;

    private Long consensusFaultElapsed;
}
