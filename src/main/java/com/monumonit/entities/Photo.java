package com.monumonit.entities;


import com.monumonit.entities.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "photo_id"))
public class Photo extends BasicEntity<Long> implements Serializable {

    @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;

    private String camera;

    private String objective;

    private String exposition;

    private String filter;

    private String shootCondition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_set_id")
    private PhotoSet photoSet;
}
