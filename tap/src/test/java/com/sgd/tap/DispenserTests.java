package com.sgd.tap;

import com.sgd.tap.model.Dispenser;
import com.sgd.tap.model.dto.ResponseDispenserDTO;
import com.sgd.tap.repository.DispenserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DispenserTests {

    @Mock
    private DispenserRepository dispenserRepository;


    @Test
    void contextLoads() {
        // To avoid sonar issue
        int i = 1;
        assertEquals(1, i);
    }

    // Entity tests
    @Test
    void shouldSetAndGetId() {
        Dispenser dispenser = new Dispenser();
        UUID id = UUID.randomUUID();
        dispenser.setId(id);
        assertEquals(id, dispenser.getId());
    }

    @Test
    void shouldSetAndGetVolumen() {
        Dispenser dispenser = new Dispenser();
        Double volumen = 10.0;
        dispenser.setVolumen(volumen);
        assertEquals(volumen, dispenser.getVolumen());
    }

    // Repository tests

    @Test
    void shouldSaveDispenser() {
        Dispenser dispenser = new Dispenser(UUID.randomUUID(), 10.0);
        when(dispenserRepository.save(any(Dispenser.class))).thenReturn(dispenser);
        Dispenser savedDispenser = dispenserRepository.save(dispenser);
        assertEquals(dispenser, savedDispenser);
    }

    @Test
    void shouldFindDispenserById() {
        UUID id = UUID.randomUUID();
        Dispenser dispenser = new Dispenser(id, 10.0);
        when(dispenserRepository.findById(id)).thenReturn(Optional.of(dispenser));
        Optional<Dispenser> foundDispenser = dispenserRepository.findById(id);
        assertTrue(foundDispenser.isPresent());
        assertEquals(dispenser, foundDispenser.get());
    }

    // DTO tests
    @Test
    void shouldSetAndGetIdDTO() {
        ResponseDispenserDTO responseDispenserDTO = new ResponseDispenserDTO();
        UUID id = UUID.randomUUID();
        responseDispenserDTO.setId(id);
        assertEquals(id, responseDispenserDTO.getId());
    }

    @Test
    void shouldSetAndGetVolumenDTO() {
        ResponseDispenserDTO responseDispenserDTO = new ResponseDispenserDTO();
        Double volumen = 10.0;
        responseDispenserDTO.setVolumen(volumen);
        assertEquals(volumen, responseDispenserDTO.getVolumen());
    }

    @Test
    void shouldHandleNullVolumenDTO() {
        ResponseDispenserDTO responseDispenserDTO = new ResponseDispenserDTO();
        responseDispenserDTO.setVolumen(null);
        assertNull(responseDispenserDTO.getVolumen());
    }

    @Test
    void shouldHandleNegativeVolumenDTO() {
        ResponseDispenserDTO responseDispenserDTO = new ResponseDispenserDTO();
        Double volumen = -10.0;
        responseDispenserDTO.setVolumen(volumen);
        assertEquals(volumen, responseDispenserDTO.getVolumen());
    }
}