package com.monumonit.services;

import com.monumonit.entities.Material;
import com.monumonit.repositories.MaterialRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MaterialService extends AbstractRecursiveService<Material> {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    protected JpaRepository<Material, Long> getRepository() {
        return materialRepository;
    }
}
