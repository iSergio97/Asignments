package com.sgd.tap.service;

import com.sgd.tap.model.dto.RequestDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserDTO;

import java.util.List;
import java.util.UUID;

public interface DispenserService {

    List<ResponseDispenserDTO> getAllDispensers();

    ResponseDispenserDTO getDispenserById(UUID id);

    ResponseDispenserDTO save(Double flowVolumen);

    ResponseDispenserDTO update(UUID id, RequestDispenserDTO dispenserDTO);

    void delete(UUID id);

}
