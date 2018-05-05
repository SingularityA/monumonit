package com.monumonit.entities;

import com.monumonit.entities.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "event_type_id"))
public class EventType extends BasicEntity<Integer> implements Serializable {

    private String name;

    private String description;
}
