package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "material_property_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_material_property_id"))
public class MaterialProperty extends RecursiveEntity<MaterialProperty> implements Serializable {

    private String name;

    private Boolean isAbstract;

    @OneToMany(mappedBy = "materialProperty",
            fetch = FetchType.LAZY)
    private List<MaterialData> materialDataList;
}
