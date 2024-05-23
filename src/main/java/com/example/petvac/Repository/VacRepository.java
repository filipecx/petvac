package com.example.petvac.Repository;

import com.example.petvac.Entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacRepository extends JpaRepository<Vaccine, String> {
}
