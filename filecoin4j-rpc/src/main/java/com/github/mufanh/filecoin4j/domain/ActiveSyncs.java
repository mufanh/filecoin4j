package com.github.mufanh.filecoin4j.domain;

import com.github.mufanh.filecoin4j.domain.types.TipSet;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xinquan.huangxq
 */
@Data
public class ActiveSyncs implements Serializable {

    private Long workerID;

    private TipSet base;

    private TipSet target;

    private Integer stage;

    private Long height;

    private Date start;

    private Date end;

    private String message;
}
