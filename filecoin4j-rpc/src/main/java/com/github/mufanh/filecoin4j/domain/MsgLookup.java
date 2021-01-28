package com.github.mufanh.filecoin4j.domain;


import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.MessageReceipt;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class MsgLookup implements Serializable {

    private Cid message;

    private MessageReceipt receipt;

    private Object returnDec;

    private TipSetKey tipSet;

    private Long height;
}
