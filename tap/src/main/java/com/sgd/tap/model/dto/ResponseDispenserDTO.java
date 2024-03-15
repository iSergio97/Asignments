package com.sgd.tap.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDispenserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1979977914256756929L;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("flow_volumen")
    private Double volumen;

    @JsonProperty("status")
    private String status;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
