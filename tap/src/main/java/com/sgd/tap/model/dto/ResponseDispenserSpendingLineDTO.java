package com.sgd.tap.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class ResponseDispenserSpendingLineDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4492585588942198716L;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("openedAt")
    private Date openedAt;

    @JsonProperty("closedAt")
    private Date closedAt;

    @JsonProperty("totalSpending")
    private Double totalSpending;

    // Relation DTOs
    @JsonProperty("dispenser")
    private ResponseDispenserDTO dispenser;
}
