package com.monumonit.services;

import com.monumonit.entities.EventType;
import com.monumonit.repositories.EventTypeRepository;
import com.monumonit.services.common.AbstractShortIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EventTypeService extends AbstractShortIdService<EventType> {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    protected JpaRepository<EventType, Integer> getRepository() {
        return eventTypeRepository;
    }
}
