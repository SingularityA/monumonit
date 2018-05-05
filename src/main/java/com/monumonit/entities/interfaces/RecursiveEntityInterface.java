package com.monumonit.entities.interfaces;

import java.io.Serializable;
import java.util.List;

public interface RecursiveEntityInterface<T extends Serializable> {

    T getParent();

    void setParent(T parent);

    List<T> getChildren();

    void setChildren(List<T> children);

    void transferChildrenTo(T parent);
}
