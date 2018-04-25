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
public class Country implements Serializable, RecursiveEntityInterface<Country> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    Long id;

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_country_id")
    Country parent;

    @OneToMany(mappedBy = "parent",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Country> children;

    public void adopt(List<Country> children) {
        children.forEach(child -> child.setParent(this));
        this.children.addAll(children);
    }

    public void transferChildrenTo(Country parent) {
        this.children.forEach(child -> child.setParent(parent));
        if (parent != null)
            parent.getChildren().addAll(children);
        this.children = new ArrayList<>();
    }
}
