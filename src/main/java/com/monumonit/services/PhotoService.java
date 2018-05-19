package com.monumonit.services;

import com.monumonit.entities.Photo;
import com.monumonit.repositories.PhotoRepository;
import com.monumonit.services.common.AbstractLongIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PhotoService extends AbstractLongIdService<Photo> {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    protected JpaRepository<Photo, Long> getRepository() {
        return photoRepository;
    }
}
