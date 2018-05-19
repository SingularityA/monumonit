package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "bio_class_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_bio_class_id"))
public class BioClass extends RecursiveEntity<BioClass> implements Serializable {

    private String name;

    private String latinName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "bio_property",
            joinColumns = @JoinColumn(name = "bio_class_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id"))
    private List<Document> documents;
}
