package com.sgd.tap.controller;

import com.sgd.tap.model.dto.ResponseDispenserDTO;
import com.sgd.tap.service.DispenserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dispenser")
@RestController
public class DispenserController {

    private final DispenserService service;

    public DispenserController(DispenserService service) {
        this.service = service;
    }

    @GetMapping("/save/{flowVolumen}")
    public ResponseDispenserDTO save(@PathVariable("flowVolumen") Double flowVolume) {
        return this.service.save(flowVolume);
    }

    @GetMapping("/getAll")
    public List<ResponseDispenserDTO> getAll() {
        return this.service.getAllDispensers();
    }
}
