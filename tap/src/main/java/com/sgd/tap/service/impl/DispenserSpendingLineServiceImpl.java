package com.sgd.tap.service.impl;

import com.sgd.tap.model.DispenserSpendingLine;
import com.sgd.tap.model.dto.RequestStatusDTO;
import com.sgd.tap.model.dto.ResponseDispenserSpendingLineDTO;
import com.sgd.tap.repository.DispenserSpendingLineRepository;
import com.sgd.tap.service.DispenserSpendingLineService;
import com.sgd.tap.service.mapper.DispenserSpendingLineMapperService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DispenserSpendingLineServiceImpl implements DispenserSpendingLineService {

    private final DispenserSpendingLineRepository repository;

    private final DispenserSpendingLineMapperService dispenserSpendingLineMapperService;

    public DispenserSpendingLineServiceImpl(
            DispenserSpendingLineRepository repository,
            DispenserSpendingLineMapperService dispenserSpendingLineMapperService
            ) {
        this.repository = repository;
        this.dispenserSpendingLineMapperService = dispenserSpendingLineMapperService;
    }

    @Override
    public List<ResponseDispenserSpendingLineDTO> getAllDispenserSpendingLineByDispenserId(UUID dispenserId) {
        List<DispenserSpendingLine> dispenserSpendingLines = this.repository.getAllDispenserSpendingLineByDispenserId(dispenserId);

        if(null == dispenserSpendingLines || dispenserSpendingLines.isEmpty()) {
            return new ArrayList<>();
        }

        return this.dispenserSpendingLineMapperService.convertListToDTO(dispenserSpendingLines);
    }

    @Override
    public ResponseDispenserSpendingLineDTO changeStatus(UUID id, RequestStatusDTO requestStatusDTO) {
        Optional<DispenserSpendingLine> optionalDispenserSpendingLine = this.repository.findById(id);
        DispenserSpendingLine dispenserSpendingLine;
        if(optionalDispenserSpendingLine.isPresent()) {
            dispenserSpendingLine = optionalDispenserSpendingLine.get();
            if(!requestStatusDTO.getStatus().equals(dispenserSpendingLine.getStatus())) {
                dispenserSpendingLine = this.repository.saveAndFlush(dispenserSpendingLine);
                return this.dispenserSpendingLineMapperService.convertToDTO(dispenserSpendingLine);
            }

        }
        return null;
    }
}
