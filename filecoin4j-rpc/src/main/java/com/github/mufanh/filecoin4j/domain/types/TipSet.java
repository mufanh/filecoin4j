package com.github.mufanh.filecoin4j.domain.types;


import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class TipSet implements Serializable {

    private List<Cid> cids;

    private List<BlockHeader> blocks;

    private Long height;
}
