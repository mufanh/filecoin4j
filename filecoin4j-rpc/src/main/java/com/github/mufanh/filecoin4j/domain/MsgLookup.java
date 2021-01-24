package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.MessageReceipt;
import com.github.mufanh.filecoin4j.domain.types.TipSetKey;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class MsgLookup implements Serializable {

    private Cid message;

    private MessageReceipt receipt;

    private String returnDec;

    private TipSetKey tipSet;

    private long height;
}
