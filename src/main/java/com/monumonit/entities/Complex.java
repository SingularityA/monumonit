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
public class Complex implements Serializable, RecursiveEntityInterface<Complex> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complex_id")
    Long id;

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    Country country;

    String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_complex_id")
    Complex parent;

    @OneToMany(mappedBy = "parent",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    List<Complex> children;

    public void adopt(List<Complex> children) {
        children.forEach(child -> child.setParent(this));
        this.children.addAll(children);
    }

    public void transferChildrenTo(Complex parent) {
        this.children.forEach(child -> child.setParent(parent));
        if (parent != null)
            parent.getChildren().addAll(children);
        this.children = new ArrayList<>();
    }

}
