package com.sgd.tapbearbackend.controller;

import com.sgd.tapbearbackend.model.Dispenser;
import com.sgd.tapbearbackend.model.DispenserSpendingLine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@RequestMapping("/dispenser")
@RestController
public class DispenserController {

    public DispenserSpendingLine demo() {
        Dispenser dispenser = new Dispenser();
        dispenser.setId(UUID.randomUUID());
        dispenser.setVolumen(1.0);

        DispenserSpendingLine dispenserSpendingLine = new DispenserSpendingLine();
        dispenserSpendingLine.setDispenser(dispenser);
        dispenserSpendingLine.setOpenedAt(new Date());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 1);
        dispenserSpendingLine.setClosedAt(cal.getTime());

        return dispenserSpendingLine;
    }
}
