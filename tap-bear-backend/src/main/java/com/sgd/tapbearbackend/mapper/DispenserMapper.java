package com.sgd.tapbearbackend.mapper;

import com.sgd.tapbearbackend.dto.ResponseDispenserDTO;
import com.sgd.tapbearbackend.model.Dispenser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DispenserMapper {

    DispenserMapper INSTANCE = Mappers.getMapper(DispenserMapper.class);

    ResponseDispenserDTO dispenserToDispenserDto(Dispenser responseDispenserDTO);
}
