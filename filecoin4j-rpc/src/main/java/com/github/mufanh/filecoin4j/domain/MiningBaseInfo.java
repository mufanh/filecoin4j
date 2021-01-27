package com.github.mufanh.filecoin4j.domain;


import com.github.mufanh.filecoin4j.domain.builtin.SectorInfo;
import com.github.mufanh.filecoin4j.domain.types.BeaconEntry;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class MiningBaseInfo implements Serializable {

    private BigInteger minerPower;

    private BigInteger networkPower;

    private List<SectorInfo> sectors;

    private String workerKey;

    private Long sectorSize;

    private BeaconEntry prevBeaconEntry;

    private List<BeaconEntry> beaconEntries;

    private Boolean eligibleForMining;
}
