package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "photo_set_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_photo_set_id"))
public class PhotoSet extends RecursiveEntity<PhotoSet> implements Serializable {

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "photoSet")
    private List<Photo> photos;
}
