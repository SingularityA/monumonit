package com.monumonit.services;

import com.monumonit.entities.BioDestruction;
import com.monumonit.repositories.BioDestructionRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BioDestructionService extends AbstractRecursiveService<BioDestruction> {

    @Autowired
    private BioDestructionRepository bioDestructionRepository;

    @Override
    protected JpaRepository<BioDestruction, Long> getRepository() {
        return bioDestructionRepository;
    }
}
