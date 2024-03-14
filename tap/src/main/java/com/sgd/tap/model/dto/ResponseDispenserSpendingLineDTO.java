package com.sgd.tap.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ResponseDispenserSpendingLineDTO {

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
