package com.sgd.tap.repository;

import com.sgd.tap.model.DispenserSpendingLine;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@CacheConfig(cacheNames = "dispenserSpendingLineRepository")
public interface DispenserSpendingLineRepository extends JpaRepository<DispenserSpendingLine, UUID> {
    List<DispenserSpendingLine> getAllDispenserSpendingLineByDispenserId(UUID dispenserId);
}
