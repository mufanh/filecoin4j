package com.github.mufanh.filecoin4j.domain.types;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class BeaconEntry implements Serializable {

    private Long round;

    private String data;
}
