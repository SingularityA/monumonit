package com.monumonit.entities;

import com.monumonit.entities.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "bio_destructor_id"))
public class BioDestructor extends BasicEntity<Long> implements Serializable {

    @ManyToOne
    @JoinColumn(name = "bio_destruction_id")
    private BioDestruction bioDestruction;

    @ManyToOne
    @JoinColumn(name = "bio_class_id")
    private BioClass bioClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private Document document;

    private Integer hazard;
}
