package com.sgd.tapbearbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestDispenserDTO {

    @JsonProperty("flowVolumen")
    private Double flowVolumen;
}
