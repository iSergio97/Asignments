package com.sgd.tap.service.mapper;

import com.sgd.tap.model.Dispenser;
import com.sgd.tap.model.dto.RequestDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DispenserMapper {

    DispenserMapper INSTANCE = Mappers.getMapper(DispenserMapper.class);

    List<ResponseDispenserDTO> convertListToDTO(List<Dispenser> dispensers);

    ResponseDispenserDTO convertToDTO(Dispenser dispenser);

    Dispenser convertToEntity(RequestDispenserDTO dispenserDTO);
}
