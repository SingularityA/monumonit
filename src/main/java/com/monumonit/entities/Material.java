package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "material_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_material_id"))
public class Material extends RecursiveEntity<Material> implements Serializable {

    private String name;

    private Boolean isBase;

    @OneToMany(mappedBy = "material",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<MaterialData> materialDataList;
}
