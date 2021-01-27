package com.github.mufanh.filecoin4j.domain.types;


import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.crypto.Signature;
import com.github.mufanh.filecoin4j.domain.proof.PoStProof;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class BlockHeader implements Serializable {

    private String miner; // 0

    private Ticket ticket; // 1

    private ElectionProof electionProof; // 2

    private List<BeaconEntry> beaconEntries; // 3

    private List<PoStProof> winPoStProof; // 4

    private List<Cid> parents; // 5

    private Long parentWeight; // 6

    private Long height; // 7

    private Cid parentStateRoot; // 8

    private Cid parentMessageReceipts; // 9

    private Cid messages; //10

    private Signature bLSAggregate; // 11

    private Long timestamp; // 12

    private Signature blockSig; // 13

    private Long forkSignaling; // 14

    private BigInteger parentBaseFee; // 15

    private Boolean validated; // 16
}
