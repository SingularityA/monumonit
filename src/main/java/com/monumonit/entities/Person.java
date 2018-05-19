package com.monumonit.entities;

import com.monumonit.entities.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "person_id"))
public class Person extends BasicEntity<Long> implements Serializable {

    private String fullName;

    private String firstName;

    private String lastName;

    private String patternName;

    private String secondName;

    @Temporal(value = TemporalType.DATE)
    private Date birthDate;

    @Temporal(value = TemporalType.DATE)
    private Date deathDate;
}
