package com.monumonit.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface BasicServiceInterface<T extends Serializable, ID_TYPE> {

    List<T> findAll();

    T find(final ID_TYPE id);

    T save(final T entity);

    T saveAndFlush(final T entity);

    List<T> saveAll(final Iterable<T> entities);

    void delete(final T entity);
}
