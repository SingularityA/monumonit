package com.monumonit.services;

import com.monumonit.entities.MaterialData;
import com.monumonit.repositories.MaterialDataRepository;
import com.monumonit.services.common.AbstractLongIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MaterialDataService extends AbstractLongIdService<MaterialData> {

    @Autowired
    private MaterialDataRepository materialDataRepository;

    @Override
    protected JpaRepository<MaterialData, Long> getRepository() {
        return materialDataRepository;
    }
}
