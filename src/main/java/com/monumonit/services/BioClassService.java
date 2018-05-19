package com.monumonit.services;

import com.monumonit.entities.BioClass;
import com.monumonit.repositories.BioClassRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BioClassService extends AbstractRecursiveService<BioClass> {

    @Autowired
    private BioClassRepository bioClassRepository;

    @Override
    protected JpaRepository<BioClass, Long> getRepository() {
        return bioClassRepository;
    }
}
