package com.monumonit.entities.common;

import com.monumonit.entities.interfaces.BasicEntityInterface;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class BasicEntity<T> implements BasicEntityInterface<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected T id;
}
