package com.sgd.tap.repository;

import com.sgd.tap.model.Dispenser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@CacheConfig(cacheNames = "dispenserRepository")
public interface DispenserRepository extends JpaRepository<Dispenser, UUID> {
}
