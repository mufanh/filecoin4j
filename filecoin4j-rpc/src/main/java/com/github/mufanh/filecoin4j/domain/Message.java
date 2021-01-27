package com.github.mufanh.filecoin4j.domain;


import com.github.mufanh.filecoin4j.domain.cid.Cid;
import lombok.Data;

/**
 * @author xinquan.huangxq
 */
@Data
public class Message {

    private Cid cid;

    private com.github.mufanh.filecoin4j.domain.types.Message message;
}
