package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "monument_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_monument_id"))
public class Monument extends RecursiveEntity<Monument> implements Serializable {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monument_type_id", nullable = false)
    private MonumentType monumentType;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complex_id")
    private Complex complex;

    @OneToMany(mappedBy = "monument",
            fetch = FetchType.LAZY)
    private List<MonumentEvent> events;
}
