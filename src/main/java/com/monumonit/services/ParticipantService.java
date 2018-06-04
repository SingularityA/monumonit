package com.monumonit.services;

import com.monumonit.entities.Participant;
import com.monumonit.repositories.ParticipantRepository;
import com.monumonit.services.common.AbstractLongIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ParticipantService extends AbstractLongIdService<Participant> {

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    protected JpaRepository<Participant, Long> getRepository() {
        return participantRepository;
    }
}
