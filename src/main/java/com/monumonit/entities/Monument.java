package com.monumonit.entities;

import com.monumonit.entities.interfaces.RecursiveEntityInterface;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DynamicUpdate
public class Monument implements Serializable, RecursiveEntityInterface<Monument> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monument_id")
    Long id;

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monument_type_id", nullable = false)
    MonumentType monumentType;

    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complex_id")
    Complex complex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_monument_id")
    Monument parent;

    @OneToMany(mappedBy = "parent",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    List<Monument> children;

    public void adopt(List<Monument> children) {
        children.forEach(child -> child.setParent(this));
        this.children.addAll(children);
    }

    public void transferChildrenTo(Monument parent) {
        this.children.forEach(child -> child.setParent(parent));
        if (parent != null)
            parent.getChildren().addAll(children);
        this.children = new ArrayList<>();
    }
}
