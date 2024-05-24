package com.example.petvac.Controller;

import com.example.petvac.Entity.Pet;
import com.example.petvac.Entity.Vaccine;
import com.example.petvac.Repository.PetRepository;
import com.example.petvac.Repository.VacRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> petList = petRepository.findAll();
        if(petList != null){
            return ResponseEntity.ok().body(petList);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> addPet(@RequestBody Pet pet){
        Pet newPet = new Pet(pet.getPicture(), pet.getName(), pet.getRace());
        petRepository.save(newPet);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/{petName}")
    public ResponseEntity<List<Vaccine>> getAllVacs(@PathVariable String petName){
        List<Vaccine> vaccines = vacRepository.findAllByPetName(petName);
        if(vaccines != null){
            return ResponseEntity.ok().body(vaccines);
        }
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/newVac")
    public ResponseEntity<Void> addVaccine(@RequestBody Vaccine vaccine){
        Vaccine newVac = new Vaccine(vaccine.getName(), vaccine.getAppDate(), vaccine.getReAppDate(), vaccine.getVetName(), vaccine.getPetName());
        Vaccine savedVac = vacRepository.save(newVac);

        return ResponseEntity.ok().build();
    }
}
