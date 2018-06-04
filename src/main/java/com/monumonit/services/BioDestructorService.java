package com.monumonit.services;

import com.monumonit.entities.BioDestructor;
import com.monumonit.repositories.BioDestructorRepository;
import com.monumonit.services.common.AbstractLongIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BioDestructorService extends AbstractLongIdService<BioDestructor> {

    @Autowired
    private BioDestructorRepository bioDestructorRepository;

    @Override
    protected JpaRepository<BioDestructor, Long> getRepository() {
        return bioDestructorRepository;
    }
}
