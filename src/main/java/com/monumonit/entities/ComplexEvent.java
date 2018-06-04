package com.monumonit.entities;

import com.monumonit.entities.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity @Data
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "complex_event_id"))
public class ComplexEvent extends BasicEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "complex_id")
    private Complex complex;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
