package com.sgd.tap.service.mapper;

import com.sgd.tap.model.Dispenser;
import com.sgd.tap.model.dto.RequestDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispenserMapperServiceImpl implements DispenserMapperService {

    private static final ModelMapper modelMapper = new ModelMapper();

    public List<ResponseDispenserDTO> convertListToDTO(List<Dispenser> dispensers) {
        return modelMapper.map(dispensers, new TypeToken<List<ResponseDispenserDTO>>(){}.getType());
    }

    public ResponseDispenserDTO convertToDTO(Dispenser dispenser) {
        return modelMapper.map(dispenser, ResponseDispenserDTO.class);
    }

    public Dispenser convertToEntity(RequestDispenserDTO dispenserDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(dispenserDTO, Dispenser.class);
    }
}
