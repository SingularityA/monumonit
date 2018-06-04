package com.monumonit.services;

import com.monumonit.entities.Event;
import com.monumonit.repositories.EventRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EventService extends AbstractRecursiveService<Event> {

    @Autowired
    private EventRepository eventRepository;

    @Override
    protected JpaRepository<Event, Long> getRepository() {
        return eventRepository;
    }
}
