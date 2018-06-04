package com.monumonit.services;

import com.monumonit.entities.Person;
import com.monumonit.repositories.PersonRepository;
import com.monumonit.services.common.AbstractLongIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersonService extends AbstractLongIdService<Person> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    protected JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }
}
