package com.monumonit.services;

import com.monumonit.entities.PhotoSet;
import com.monumonit.repositories.PhotoSetRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PhotoSetService extends AbstractRecursiveService<PhotoSet> {

    @Autowired
    private PhotoSetRepository photoSetRepository;

    protected JpaRepository<PhotoSet, Long> getRepository() {
        return photoSetRepository;
    }
}
