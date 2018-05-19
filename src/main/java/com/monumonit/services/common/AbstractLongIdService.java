package com.monumonit.services.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Transactional
public abstract class AbstractLongIdService<T extends Serializable> extends AbstractBasicService<T, Long> {

    protected abstract JpaRepository<T, Long> getRepository();

    @Override
    @Transactional(readOnly = true)
    public T find(final Long id) {
        Optional<T> entity = getRepository().findById(id);
        return entity.orElse(null);
    }
}
