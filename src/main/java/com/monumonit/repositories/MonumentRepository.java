package com.monumonit.repositories;

import com.monumonit.entities.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, Long> {
}
