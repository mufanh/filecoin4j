package com.github.mufanh.filecoin4j.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class ObjStat implements Serializable {

    private long size;

    private long links;
}
