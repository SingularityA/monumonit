package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "complex_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_complex_id"))
public class Complex extends RecursiveEntity<Complex> implements Serializable {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    private String address;

    @OneToMany(mappedBy = "complex",
            fetch = FetchType.LAZY)
    private List<Monument> monuments;
}
