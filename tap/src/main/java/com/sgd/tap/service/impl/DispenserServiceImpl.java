package com.sgd.tap.service.impl;

import com.sgd.tap.model.Dispenser;
import com.sgd.tap.model.dto.RequestDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserDTO;
import com.sgd.tap.repository.DispenserRepository;
import com.sgd.tap.service.mapper.DispenserMapperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DispenserServiceImpl implements com.sgd.tap.service.DispenserService {

    private final DispenserRepository repository;
    
    private final DispenserMapperService dispenserMapperService;

    public DispenserServiceImpl(
            DispenserRepository repository,
            DispenserMapperService dispenserMapperService
    ) {
        this.repository = repository;
        this.dispenserMapperService = dispenserMapperService;
    }

    @Override
    public Optional<ResponseDispenserDTO> findByDispenserId(UUID id) {
        return this.repository.findById(id).map(this.dispenserMapperService::convertToDTO);
    }

    @Override
    public List<ResponseDispenserDTO> getAllDispensers() {
        List<Dispenser> dispensers = this.repository.findAll();

        return this.dispenserMapperService.convertListToDTO(dispensers);
    }

    @Override
    public ResponseDispenserDTO getDispenserById(UUID id) {
        Dispenser dispenser = this.repository.findById(id).orElse(null);
        if(null == dispenser) {
            return null;
        }
        return this.dispenserMapperService.convertToDTO(dispenser);
    }

    @Override
    public ResponseDispenserDTO save(Double flowVolumen) {
        Dispenser dispenser = new Dispenser();
        dispenser.setId(UUID.randomUUID());
        dispenser.setVolumen(flowVolumen);
        dispenser = this.repository.saveAndFlush(dispenser);
        return this.dispenserMapperService.convertToDTO(dispenser);
    }

    @Override
    public ResponseDispenserDTO update(UUID id, RequestDispenserDTO dispenserDTO) {
        Dispenser dispenser = this.repository.findById(id).orElse(null);
        if(null == dispenser) {
            return null;
        }
        dispenser = this.dispenserMapperService.convertToEntity(dispenserDTO);
        dispenser = this.repository.saveAndFlush(dispenser);

        return this.dispenserMapperService.convertToDTO(dispenser);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }
}
