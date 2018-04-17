package com.monumonit.services;

import com.google.common.collect.Lists;
import com.monumonit.services.interfaces.BasicServiceInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Transactional
public abstract class AbstractBasicService<T extends Serializable> implements BasicServiceInterface<T> {

    protected abstract JpaRepository<T, Long> getRepository();

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getRepository().findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public T find(final Long id) {
        Optional<T> entity = getRepository().findById(id);
        return entity.isPresent() ? entity.get() : null;
    }

    @Override
    public T save(final T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(final T entity) {
        getRepository().delete(entity);
    }
}
