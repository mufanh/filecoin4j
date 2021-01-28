package com.github.mufanh.filecoin4j.domain.types;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class Loc implements Serializable {

    private String file;

    private Integer line;

    private String function;
}
