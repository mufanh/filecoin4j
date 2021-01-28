package com.github.mufanh.filecoin4j.domain.types;


import com.github.mufanh.filecoin4j.domain.crypto.Signature;
import com.github.mufanh.filecoin4j.domain.types.Message;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class SignedMessage implements Serializable {

    private Message message;

    private Signature signature;
}
