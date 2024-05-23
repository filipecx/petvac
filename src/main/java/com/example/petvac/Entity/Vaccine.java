package com.example.petvac.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccines")
public class Vaccine {

    @Column(name = "name")
    private String name;

    @Column(name = "appDate")
    private String appDate;

    @Column(name = "reAppDate")
    private String reAppDate;

    @Column(name = "vetName")
    private String vetName;
}
