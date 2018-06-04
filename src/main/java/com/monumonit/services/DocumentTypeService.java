package com.monumonit.services;

import com.monumonit.entities.DocumentType;
import com.monumonit.repositories.DocumentTypeRepository;
import com.monumonit.services.common.AbstractShortIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DocumentTypeService extends AbstractShortIdService<DocumentType> {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Override
    protected JpaRepository<DocumentType, Integer> getRepository() {
        return documentTypeRepository;
    }
}
