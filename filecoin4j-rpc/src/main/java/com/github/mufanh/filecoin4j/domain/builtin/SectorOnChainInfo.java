package com.github.mufanh.filecoin4j.domain.builtin;

import com.github.mufanh.filecoin4j.domain.abi.RegisteredSealProof;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class SectorOnChainInfo {

    private Long sectorNumber;

    private RegisteredSealProof sealProof;

    private Cid sealedCID;

    private List<Long> dealIDs;

    private Long activation;

    private Long expiration;

    private BigInteger dealWeight;

    private BigInteger verifiedDealWeight;

    private BigInteger initialPledge;

    private BigInteger expectedDayReward;

    private BigInteger expectedStoragePledge;
}
