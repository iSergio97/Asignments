package com.sgd.tap.controller;

import com.sgd.tap.model.Dispenser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/dispenser")
@RestController
public class DispenserController {

    @GetMapping("/demo")
    public Dispenser demo() {
        Dispenser dispenser = new Dispenser();
        dispenser.setId(UUID.randomUUID());
        dispenser.setVolumen(1.0);

        return dispenser;
    }
}
