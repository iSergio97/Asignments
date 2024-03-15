package com.sgd.tap.service.mapper;

import com.sgd.tap.model.DispenserSpendingLine;
import com.sgd.tap.model.dto.ResponseDispenserSpendingLineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DispenserSpendingLineMapper {

    DispenserSpendingLineMapper INSTANCE = Mappers.getMapper(DispenserSpendingLineMapper.class);

    List<ResponseDispenserSpendingLineDTO> convertListToDTO(List<DispenserSpendingLine> dispenserSpendingLines);

    ResponseDispenserSpendingLineDTO convertToDTO(DispenserSpendingLine dispenserSpendingLine);
}

