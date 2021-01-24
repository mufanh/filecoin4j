package com.github.mufanh.filecoin4j.domain.cid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xinquan.huangxq
 */
@Data
public class Cid implements Serializable {

    @JsonProperty("/")
    private String str;

    public static Cid of(String str) {
        Cid result = new Cid();
        result.str = str;
        return result;
    }
}
