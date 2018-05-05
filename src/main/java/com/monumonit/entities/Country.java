package com.monumonit.entities;

import com.monumonit.entities.common.RecursiveEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "country_id"))
@AssociationOverride(name = "parent", joinColumns = @JoinColumn(name = "part_country_id"))
public class Country extends RecursiveEntity<Country> implements Serializable {

    private String name;
}
