package com.github.mufanh.filecoin4j.domain.builtin;

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
public class MinerInfo implements Serializable {

    private String owner;

    private String worker;

    private String newWorker;

    private List<String> controlAddresses;

    private long workerChangeEpoch;

    private String peerId;

    private List<String> multiaddrs;

    private long sealProofType;

    private long sectorSize;

    private long windowPoStPartitionSectors;

    private long consensusFaultElapsed;
}
