package com.monumonit.services;

import com.monumonit.entities.Complex;
import com.monumonit.repositories.ComplexRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComplexService extends AbstractRecursiveService<Complex> {

    @Autowired
    ComplexRepository complexRepository;

    @Override
    protected JpaRepository<Complex, Long> getRepository() {
        return complexRepository;
    }
}
