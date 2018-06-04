package com.monumonit.dto;

import com.monumonit.entities.Monument;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
public class MonumentDto {

    @Null
    private Long id;

    @Size(max = 100)
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Integer typeId;

    @Size(max = 200)
    private String description;

    @NotNull
    private Long complexId;

    @Null
    private Long parentId;

    public void map(Monument monument) {
        this.id = monument.getId();
        this.name = monument.getName();
        this.typeId = monument.getMonumentType().getId();
        this.description = monument.getDescription();
        this.complexId = monument.getComplex().getId();
        this.parentId = monument.getParent() != null ? monument.getParent().getId() : null;
    }

    public void mapInto(Monument monument) {
        monument.setId(this.id);
        monument.setName(this.name);

        if (this.description != null) {
            if (this.description.isEmpty()) {
                this.description = null;
            }
        }
        monument.setDescription(this.description);
    }
}
