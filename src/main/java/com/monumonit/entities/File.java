package com.monumonit.entities;


import com.monumonit.entities.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "file_id"))
public class File extends BasicEntity<Long> implements Serializable {

    private String name;

    private String filePath;

    private String contentType;
}
