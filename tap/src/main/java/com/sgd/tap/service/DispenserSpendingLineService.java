package com.sgd.tap.service;

import com.sgd.tap.model.dto.RequestStatusDTO;
import com.sgd.tap.model.dto.ResponseDispenserSpendingLineDTO;

import java.util.List;
import java.util.UUID;

public interface DispenserSpendingLineService {
    List<ResponseDispenserSpendingLineDTO> getAllDispenserSpendingLineByDispenserId(UUID dispenserId);

    ResponseDispenserSpendingLineDTO changeStatus(UUID id, RequestStatusDTO requestStatusDTO);
}
