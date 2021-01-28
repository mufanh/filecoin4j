package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class GasTrace implements Serializable {

    private String name;

    @JsonProperty("loc")
    private List<Loc> location;

    @JsonProperty("tg")
    private Long totalGas;

    @JsonProperty("cg")
    private Long computeGas;

    @JsonProperty("sg")
    private Long storageGas;

    @JsonProperty("vtg")
    private Long totalVirtualGas;

    @JsonProperty("vcg")
    private Long virtualComputeGas;

    @JsonProperty("vsg")
    private Long virtualStorageGas;

    @JsonProperty("tt")
    private Long timeTaken;

    @JsonProperty("ex")
    private Object extra;
}
