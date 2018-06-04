package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "country_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_country_id"))
public class Country extends RecursiveEntity<Country> implements Serializable {

    private String name;

    @OneToMany(mappedBy = "country",
            fetch = FetchType.LAZY)
    private List<Complex> complexes;
}
