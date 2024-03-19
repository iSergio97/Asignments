package com.sgd.tap.controller;

import com.sgd.tap.model.dto.RequestStatusDTO;
import com.sgd.tap.model.dto.ResponseDispenserDTO;
import com.sgd.tap.model.dto.ResponseDispenserSpendingLineDTO;
import com.sgd.tap.service.DispenserService;
import com.sgd.tap.service.DispenserSpendingLineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/dispenser")
@RestController
public class DispenserController {

    private final DispenserService dispenserService;

    private final DispenserSpendingLineService dispenserSpendingLineService;

    public DispenserController(
            DispenserService dispenserService,
            DispenserSpendingLineService dispenserSpendingLineService
    ) {
        this.dispenserService = dispenserService;
        this.dispenserSpendingLineService = dispenserSpendingLineService;
    }

    @GetMapping("/{flowVolumen}")
    public ResponseEntity<ResponseDispenserDTO> save(@PathVariable("flowVolumen") Double flowVolume) {
        ResponseDispenserDTO responseDispenserDTO = this.dispenserService.save(flowVolume);
        return new ResponseEntity<>(responseDispenserDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ResponseDispenserSpendingLineDTO> status(@PathVariable("id") String id, @RequestBody RequestStatusDTO requestStatusDTO) {
        ResponseDispenserSpendingLineDTO responseDispenserSpendingLineDTO = this.dispenserSpendingLineService.changeStatus(UUID.fromString(id), requestStatusDTO);
        if(null == responseDispenserSpendingLineDTO) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(responseDispenserSpendingLineDTO, HttpStatus.ACCEPTED);
    }

}
