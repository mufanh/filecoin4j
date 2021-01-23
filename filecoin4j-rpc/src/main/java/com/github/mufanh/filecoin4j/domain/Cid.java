package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class Cid implements Serializable {

    @JsonProperty("/")
    private String id;
}
