package com.sgd.tap.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class RequestStatusDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5327555252565206371L;

    @JsonProperty("status")
    private String status;

    @JsonProperty("updateAt")
    private Date updateAt;
}
