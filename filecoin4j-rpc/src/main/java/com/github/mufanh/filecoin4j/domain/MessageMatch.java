package com.github.mufanh.filecoin4j.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class MessageMatch implements Serializable {

    private String from;

    private String to;

    public static MessageMatch of(String from, String to) {
        MessageMatch messageMatch = new MessageMatch();
        messageMatch.setFrom(from);
        messageMatch.setTo(to);
        return messageMatch;
    }
}
