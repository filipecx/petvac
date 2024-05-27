package com.example.petvac.Repository;

import com.example.petvac.Entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacRepository extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findAllByPetName(String petName);
}
