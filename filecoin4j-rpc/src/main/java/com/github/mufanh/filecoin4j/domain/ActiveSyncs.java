package com.github.mufanh.filecoin4j.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.mufanh.filecoin4j.domain.types.TipSet;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author xinquan.huangxq
 */
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
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
