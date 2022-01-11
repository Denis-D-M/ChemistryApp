package com.example.chemistryapp.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@ToString
@Entity(name = "CHEMISTRY_ENTITY")
public class ChemistryEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
