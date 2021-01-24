package com.github.mufanh.filecoin4j.domain.types;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class TipSet implements Serializable {

    private List<Cid> cids;

    private List<BlockHeader> blocks;

    private long height;
}
