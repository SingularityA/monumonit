package com.monumonit.services.common;

import com.monumonit.entities.interfaces.RecursiveEntityInterface;
import com.monumonit.services.interfaces.RecursiveServiceInterface;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public abstract class AbstractRecursiveService<T extends Serializable & RecursiveEntityInterface<T>>
        extends AbstractLongIdService<T>
        implements RecursiveServiceInterface<T> {

    @Override
    public T save(final T entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public void delete(final T entity) {
        if (!entity.getChildren().isEmpty()) {
            // if entity is a node
            entity.transferChildrenTo(entity.getParent());
        }
        getRepository().delete(entity);
    }

    @Override
    public void deleteWithChildren(final T entity) {
        getRepository().delete(entity);
    }
}
