package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "bio_destruction_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_bio_destruction_id"))
public class BioDestruction extends RecursiveEntity<BioDestruction> implements Serializable {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;

    private Integer danger;

    @OneToMany(mappedBy = "bioDestruction",
            cascade = CascadeType.ALL)
    private List<BioDestructor> bioDestructors;
}
