package com.example.petvac.Repository;

import com.example.petvac.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {
    Pet findByName(String petName);
}
