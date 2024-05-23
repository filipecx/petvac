package com.example.petvac.Controller;

import com.example.petvac.Entity.Vaccine;
import com.example.petvac.Repository.PetRepository;
import com.example.petvac.Repository.VacRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/petvac")
public class PetController {

    VacRepository vacRepository;
    PetRepository petRepository;

    public PetController (VacRepository vacRepository, PetRepository petRepository){
        this.vacRepository = vacRepository;
        this.petRepository = petRepository;
    }

    @GetMapping
    public ResponseEntity<List<Vaccine>> getAllVacs(){
        List<Vaccine> vaccines = vacRepository.findAll();
        if(vaccines != null){
            return ResponseEntity.ok().body(vaccines);
        }
        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<Void> addVaccine(@RequestBody Vaccine vaccine){
        Vaccine newVac = new Vaccine(vaccine.getName(), vaccine.getAppDate(), vaccine.getReAppDate(), vaccine.getVetName());
        Vaccine savedVac = vacRepository.save(newVac);

        return ResponseEntity.ok().build();
    }
}
