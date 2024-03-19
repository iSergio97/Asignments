package com.sgd.tap.service.mapper;

import com.sgd.tap.model.DispenserSpendingLine;
import com.sgd.tap.model.dto.ResponseDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserSpendingLineDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispenserSpendingLineMapperServiceImpl implements DispenserSpendingLineMapperService {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ResponseDispenserSpendingLineDTO> convertListToDTO(List<DispenserSpendingLine> dispenserSpendingLines) {
        return modelMapper.map(dispenserSpendingLines, new TypeToken<List<ResponseDispenserDTO>>(){}.getType());
    }

    @Override
    public ResponseDispenserSpendingLineDTO convertToDTO(DispenserSpendingLine dispenserSpendingLine) {
        return modelMapper.map(dispenserSpendingLine, ResponseDispenserSpendingLineDTO.class);
    }

    @Override
    public DispenserSpendingLine convertToEntity(ResponseDispenserSpendingLineDTO dispenserSpendingLineDTO) {
        return modelMapper.map(dispenserSpendingLineDTO, DispenserSpendingLine.class);
    }
}
