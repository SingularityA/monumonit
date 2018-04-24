package com.monumonit.services;

import com.monumonit.entities.MonumentType;
import com.monumonit.repositories.MonumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MonumentTypeService extends AbstractIntegerIdService<MonumentType> {

    @Autowired
    MonumentTypeRepository monumentTypeRepository;

    @Override
    protected JpaRepository<MonumentType, Integer> getRepository() {
        return monumentTypeRepository;
    }
}
