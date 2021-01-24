package com.github.mufanh.filecoin4j.domain.crypto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class Signature implements Serializable {

    private Integer type;

    private String data;
}
