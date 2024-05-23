package com.example.petvac.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "pets")
@Table(name = "pets")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "picture", columnDefinition = "TEXT")
    private String picture;

    @Column(name = "name")
    private String name;

    @Column(name = "race")
    private String race;

    public Pet() {
    }

    public Pet(Long id, String picture, String name, String race) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.race = race;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
