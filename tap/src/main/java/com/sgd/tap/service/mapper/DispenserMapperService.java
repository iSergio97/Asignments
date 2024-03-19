package com.sgd.tap.service.mapper;

import com.sgd.tap.model.Dispenser;
import com.sgd.tap.model.dto.RequestDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserDTO;

import java.util.List;


public interface DispenserMapperService {

    List<ResponseDispenserDTO> convertListToDTO(List<Dispenser> dispensers);

    ResponseDispenserDTO convertToDTO(Dispenser dispenser);

    Dispenser convertToEntity(RequestDispenserDTO dispenserDTO);
}
