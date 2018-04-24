package com.monumonit.services.interfaces;

import com.monumonit.entities.interfaces.RecursiveEntityInterface;

import java.io.Serializable;

public interface RecursiveServiceInterface<T extends Serializable & RecursiveEntityInterface<T>>
        extends BasicServiceInterface<T, Long>{
    void deleteWithChildren(final T entity);
}
