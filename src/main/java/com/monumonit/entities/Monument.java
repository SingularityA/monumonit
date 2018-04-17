package com.monumonit.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Monument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monument_id")
    Long id;

    String name;

    Long complexId;

    Long partMonumentId;
}
