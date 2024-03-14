package com.sgd.tapbearbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDispenserDTO implements Serializable {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("flow_volumen")
    private Double volumen;
}
