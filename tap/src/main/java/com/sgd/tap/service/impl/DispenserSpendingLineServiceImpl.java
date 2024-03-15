package com.sgd.tap.service.impl;

import com.sgd.tap.model.DispenserSpendingLine;
import com.sgd.tap.model.dto.RequestStatusDTO;
import com.sgd.tap.model.dto.ResponseDispenserSpendingLineDTO;
import com.sgd.tap.repository.DispenserRepository;
import com.sgd.tap.repository.DispenserSpendingLineRepository;
import com.sgd.tap.service.DispenserSpendingLineService;
import com.sgd.tap.service.mapper.DispenserSpendingLineMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DispenserSpendingLineServiceImpl implements DispenserSpendingLineService {

    private final DispenserSpendingLineRepository repository;

    private final DispenserRepository dispenserRepository;

    private DispenserSpendingLineMapper dispenserSpendingLineMapper;

    public DispenserSpendingLineServiceImpl(DispenserSpendingLineRepository repository, DispenserRepository dispenserRepository) {
        this.repository = repository;
        this.dispenserRepository = dispenserRepository;
        this.dispenserSpendingLineMapper = DispenserSpendingLineMapper.INSTANCE;
    }

    @Override
    public List<ResponseDispenserSpendingLineDTO> getAllDispenserSpendingLineByDispenserId(UUID dispenserId) {
        List<DispenserSpendingLine> dispenserSpendingLines = this.repository.getAllDispenserSpendingLineByDispenserId(dispenserId);

        if(null == dispenserSpendingLines || dispenserSpendingLines.isEmpty()) {
            return new ArrayList<>();
        }

        return this.dispenserSpendingLineMapper.convertListToDTO(dispenserSpendingLines);
    }

    @Override
    public ResponseDispenserSpendingLineDTO changeStatus(UUID id, RequestStatusDTO requestStatusDTO) {
        Optional<DispenserSpendingLine> optionalDispenserSpendingLine = this.repository.findById(id);
        DispenserSpendingLine dispenserSpendingLine;
        if(optionalDispenserSpendingLine.isPresent()) {
            dispenserSpendingLine = optionalDispenserSpendingLine.get();
            if(!requestStatusDTO.getStatus().equals(dispenserSpendingLine.getStatus())) {
                dispenserSpendingLine = this.repository.saveAndFlush(dispenserSpendingLine);
                return this.dispenserSpendingLineMapper.convertToDTO(dispenserSpendingLine);
            }

        }
        return null;
    }
}
