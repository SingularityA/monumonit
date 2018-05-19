package com.monumonit.services;

import com.monumonit.entities.File;
import com.monumonit.repositories.FileRepository;
import com.monumonit.services.common.AbstractLongIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class FileService extends AbstractLongIdService<File> {

    @Autowired
    private FileRepository fileRepository;

    @Override
    protected JpaRepository<File, Long> getRepository() {
        return fileRepository;
    }
}
