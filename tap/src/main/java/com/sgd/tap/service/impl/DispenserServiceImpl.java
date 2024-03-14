package com.sgd.tap.service.impl;

import com.sgd.tap.model.Dispenser;
import com.sgd.tap.model.dto.RequestDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserDTO;
import com.sgd.tap.repository.DispenserRepository;
import com.sgd.tap.service.DispenserService;
import com.sgd.tap.service.mapper.DispenserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DispenserServiceImpl implements DispenserService {


    private final DispenserRepository repository;
    
    private final DispenserMapper dispenserMapper;

    public DispenserServiceImpl(DispenserRepository repository) {
        this.repository = repository;
        this.dispenserMapper = DispenserMapper.INSTANCE;
    }

    @Override
    public List<ResponseDispenserDTO> getAllDispensers() {
        List<Dispenser> dispensers = this.repository.findAll();

        return this.dispenserMapper.convertListToDTO(dispensers);
    }

    @Override
    public ResponseDispenserDTO getDispenserById(UUID id) {
        Dispenser dispenser = this.repository.findById(id).orElse(null);
        if(null == dispenser) {
            return null;
        }
        return this.dispenserMapper.convertToDTO(dispenser);
    }

    @Override
    public ResponseDispenserDTO save(Double flowVolumen) {
        Dispenser dispenser = new Dispenser();
        dispenser.setId(UUID.randomUUID());
        dispenser.setVolumen(flowVolumen);
        dispenser = this.repository.saveAndFlush(dispenser);
        return this.dispenserMapper.convertToDTO(dispenser);
    }

    @Override
    public ResponseDispenserDTO update(UUID id, RequestDispenserDTO dispenserDTO) {
        Dispenser dispenser = this.repository.findById(id).orElse(null);
        if(null == dispenser) {
            return null;
        }
        dispenser = this.dispenserMapper.convertToEntity(dispenserDTO);
        dispenser = this.repository.saveAndFlush(dispenser);

        return this.dispenserMapper.convertToDTO(dispenser);
    }

    @Override
    public void delete(UUID id) {
        this.repository.findById(id).ifPresent(this.repository::delete);
    }
}
