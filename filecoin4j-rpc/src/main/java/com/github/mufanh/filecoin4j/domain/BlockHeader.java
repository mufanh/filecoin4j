package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class BlockHeader implements Serializable {

    private String miner; // 0

    private Ticket ticket; // 1

    private ElectionProof electionProof; // 2

    private List<BeaconEntry> beaconEntries; // 3

    private List<PoStProof> winPoStProof; // 4

    private List<Cid> parents; // 5

    private long parentWeight; // 6

    private long height; // 7

    private Cid parentStateRoot; // 8

    private Cid parentMessageReceipts; // 9

    private Cid messages; //10

    private Signature bLSAggregate; // 11

    private long timestamp; // 12

    private Signature blockSig; // 13

    private long forkSignaling; // 14

    private BigInteger parentBaseFee; // 15

    private boolean validated; // 16
}
