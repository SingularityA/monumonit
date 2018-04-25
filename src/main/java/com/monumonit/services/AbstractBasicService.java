package com.monumonit.services;

import com.google.common.collect.Lists;
import com.monumonit.services.interfaces.BasicServiceInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Transactional
public abstract class AbstractBasicService<T extends Serializable, ID_TYPE> implements BasicServiceInterface<T, ID_TYPE> {

    protected abstract JpaRepository<T, ID_TYPE> getRepository();

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getRepository().findAll());
    }

    @Override
    public T save(final T entity) {
        return getRepository().save(entity);
    }

    @Override
    public List<T> saveAll(final Iterable<T> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    public T saveAndFlush(final T entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public void delete(final T entity) {
        getRepository().delete(entity);
    }
}
