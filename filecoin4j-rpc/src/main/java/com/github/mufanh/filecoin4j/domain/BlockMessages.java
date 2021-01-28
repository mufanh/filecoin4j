package com.github.mufanh.filecoin4j.domain;


import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.Message;
import com.github.mufanh.filecoin4j.domain.types.SignedMessage;
import lombok.Data;

import java.util.List;

/**
 * @author xinquan.huangxq
 */
@Data
public class BlockMessages {

    private List<Message> blsMessages;

    private List<SignedMessage> secpkMessages;

    private List<Cid> cids;
}
