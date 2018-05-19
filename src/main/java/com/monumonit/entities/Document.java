package com.monumonit.entities;

import com.monumonit.entities.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "document_id"))
public class Document extends BasicEntity<Long> implements Serializable {

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date creationTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastEditTime;

    @OneToOne
    @JoinColumn(name = "file_id")
    private File file;

    private String version;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_document_id")
    private Document lastDocument;

    @OneToOne(mappedBy = "lastDocument", fetch = FetchType.LAZY)
    private Document nextDocument;

    private String description;
}
