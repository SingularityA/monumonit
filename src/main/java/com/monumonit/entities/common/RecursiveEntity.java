package com.monumonit.entities.common;

import com.monumonit.entities.interfaces.RecursiveEntityInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data @EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class RecursiveEntity<T extends Serializable & RecursiveEntityInterface<T>>
        extends BasicEntity<Long>
        implements RecursiveEntityInterface<T> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PART_ENTITY_ID")
    protected T parent;

    @OneToMany(mappedBy = "parent",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    protected List<T> children;

    public void transferChildrenTo(T parent) {
        this.children.forEach(child -> child.setParent(parent));
        if (parent != null)
            parent.getChildren().addAll(children);
        this.children = new ArrayList<>();
    }
}
