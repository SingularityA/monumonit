package com.monumonit.services;

import com.monumonit.entities.MaterialProperty;
import com.monumonit.repositories.MaterialPropertyRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MaterialPropertyService extends AbstractRecursiveService<MaterialProperty> {

    @Autowired
    private MaterialPropertyRepository materialPropertyRepository;

    @Override
    protected JpaRepository<MaterialProperty, Long> getRepository() {
        return  materialPropertyRepository;
    }
}
