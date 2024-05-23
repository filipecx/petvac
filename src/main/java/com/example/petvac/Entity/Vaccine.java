package com.example.petvac.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "vaccines")
@Table(name = "vaccines")

public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "appDate")
    private String appDate;

    @Column(name = "reAppDate")
    private String reAppDate;

    @Column(name = "vetName")
    private String vetName;

    public Vaccine() {
    }

    public Vaccine(String name, String appDate, String reAppDate, String vetName) {
        this.name = name;
        this.appDate = appDate;
        this.reAppDate = reAppDate;
        this.vetName = vetName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getReAppDate() {
        return reAppDate;
    }

    public void setReAppDate(String reAppDate) {
        this.reAppDate = reAppDate;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }
}
