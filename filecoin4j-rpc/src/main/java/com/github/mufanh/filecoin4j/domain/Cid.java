package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
public class Cid implements Serializable {

    @JsonProperty("/")
    private String id;
}
