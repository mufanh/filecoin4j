package com.github.mufanh.filecoin4j.domain.crypto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class Signature implements Serializable {

    private SigType type;

    private String data;
}
