package com.monumonit.services.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Transactional
public abstract class AbstractIntegerIdService<T extends Serializable> extends AbstractBasicService<T, Integer> {
    protected abstract JpaRepository<T, Integer> getRepository();

    @Override
    @Transactional(readOnly = true)
    public T find(final Integer id) {
        Optional<T> entity = getRepository().findById(id);
        return entity.orElse(null);
    }
}
