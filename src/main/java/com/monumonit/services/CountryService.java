package com.monumonit.services;

import com.monumonit.entities.Country;
import com.monumonit.repositories.CountryRepository;
import com.monumonit.services.common.AbstractRecursiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CountryService extends AbstractRecursiveService<Country> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    protected JpaRepository<Country, Long> getRepository() {
        return countryRepository;
    }
}
