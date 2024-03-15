package com.sgd.tap.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class ResponseDispenserTapClosedDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2132945471701560811L;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("usages")
    private List<ResponseDispenserSpendingLineDTO> usages;
}
