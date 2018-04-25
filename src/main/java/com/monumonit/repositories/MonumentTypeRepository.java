package com.monumonit.repositories;

import com.monumonit.entities.MonumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentTypeRepository extends JpaRepository<MonumentType, Integer> {
}
