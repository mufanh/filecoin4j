package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.Message;
import lombok.Data;

import java.util.List;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class BlockMessages {

    private List<Message> blsMessages;

    private List<SignedMessage> secpkMessages;

    private List<Cid> cids;
}
