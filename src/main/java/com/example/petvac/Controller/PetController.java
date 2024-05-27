package com.example.petvac.Controller;

import com.example.petvac.Entity.Pet;
import com.example.petvac.Entity.Vaccine;
import com.example.petvac.Repository.PetRepository;
import com.example.petvac.Repository.VacRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets(){
        List<Pet> petList = petRepository.findAll();
        /*
        List<String> petsNames = new ArrayList<>();
        for(Pet pet : petList) {
            petsNames.add(pet.getName());
        }*/
        if(petList != null){
            return ResponseEntity.ok().body(petList);
        }
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Void> addPet(@RequestBody Pet pet){
        Pet newPet = new Pet(pet.getPicture(), pet.getName(), pet.getRace());
        petRepository.save(newPet);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{petName}")
    public ResponseEntity<Pet> getPet(@PathVariable String petName){
        Pet pet = petRepository.findByName(petName);
        return ResponseEntity.ok().body(pet);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/vaccines/{petName}")
    public ResponseEntity<List<Vaccine>> getAllVacs(@PathVariable String petName){
        List<Vaccine> vaccines = vacRepository.findAllByPetName(petName);
        if(vaccines != null){
            return ResponseEntity.ok().body(vaccines);
        }
        return ResponseEntity.noContent().build();

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/vaccines")
    public ResponseEntity<Void> addVaccine(@RequestBody Vaccine vaccine){
        Vaccine newVac = new Vaccine(vaccine.getName(), vaccine.getAppDate(), vaccine.getReAppDate(), vaccine.getVetName(), vaccine.getPetName());
        Vaccine savedVac = vacRepository.save(newVac);

        return ResponseEntity.ok().build();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/vaccines/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable Long id){
        if(vacRepository.existsById(id)){
            vacRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
