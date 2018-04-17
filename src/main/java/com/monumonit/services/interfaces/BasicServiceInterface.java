package com.monumonit.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface BasicServiceInterface<T extends Serializable> {

    List<T> findAll();

    T find(final Long id);

    T save(final T entity);

    void delete(final T entity);
}
