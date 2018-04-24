package com.monumonit.entities;

import com.monumonit.entities.interfaces.RecursiveEntityInterface;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Monument implements Serializable, RecursiveEntityInterface<Monument> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monument_id")
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "monument_type_id")
    MonumentType monumentType;

    String description;

    @ManyToOne
    @JoinColumn(name = "complex_id")
    Complex complex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_monument_id")
    Monument parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    List<Monument> children;
}
