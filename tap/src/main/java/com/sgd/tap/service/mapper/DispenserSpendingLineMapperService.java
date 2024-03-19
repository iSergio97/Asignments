package com.sgd.tap.service.mapper;

import com.sgd.tap.model.DispenserSpendingLine;
import com.sgd.tap.model.dto.ResponseDispenserSpendingLineDTO;

import java.util.List;

public interface DispenserSpendingLineMapperService {

    List<ResponseDispenserSpendingLineDTO> convertListToDTO(List<DispenserSpendingLine> dispenserSpendingLines);

    ResponseDispenserSpendingLineDTO convertToDTO(DispenserSpendingLine dispenserSpendingLine);

    DispenserSpendingLine convertToEntity(ResponseDispenserSpendingLineDTO dispenserSpendingLineDTO);
}

