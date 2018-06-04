package com.monumonit.services;

import com.monumonit.entities.Document;
import com.monumonit.repositories.DocumentRepository;
import com.monumonit.services.common.AbstractLongIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DocumentService extends AbstractLongIdService<Document> {

    @Autowired
    private DocumentRepository documentRepository;

    protected JpaRepository<Document, Long> getRepository() {
        return documentRepository;
    }
}
