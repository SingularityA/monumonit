package com.monumonit.services;

import com.monumonit.entities.Monument;
import com.monumonit.repositories.MonumentRepository;
import com.monumonit.services.interfaces.MonumentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MonumentService extends AbstractBasicService<Monument> implements MonumentServiceInterface {

    @Autowired
    private MonumentRepository monumentRepository;

    @Override
    protected JpaRepository<Monument, Long> getRepository() {
        return monumentRepository;
    }
}
