package com.group2.petcareinfotype.controller;

import com.group2.petcareinfotype.entity.Pet;
import com.group2.petcareinfotype.repository.PetRepository;
import com.group2.petcareinfotype.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "v1/pet")
@Slf4j
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping(value = "/searchByUser")
    public ResponseEntity<List<Pet>> searchAllByUser(@RequestParam(name = "userId", required = false) Long userId) {
        return ResponseEntity.accepted().body(petService.getAllPets(userId));
    }

    @GetMapping(value = "/create")
    public ResponseEntity<Pet> createNewPet(@RequestParam(name = "ownerId", required = true) Long ownerId,
                             @RequestParam(name = "name", required = false) String name,
                             @RequestParam(name = "species", required = false) String species,
                             @RequestParam(name = "age", required = false) Integer age,
                             @RequestParam(name = "gender", required = false) String gender,
                             @RequestParam(name = "weight", required = false) Double weight) {
        Pet newPet = Pet.builder()
                .ownerId(ownerId)
                .name(name)
                .species(species)
                .gender(gender)
                .age(age)
                .weight(weight).build();
        return ResponseEntity.accepted().body(petService.ceatePet(newPet));
    }

    @GetMapping(value = "/update")
    public ResponseEntity<Pet> updatePet(@RequestParam(name = "id", required = true) Long id,
                                         @RequestParam(name = "ownerId", required = false) Long ownerId,
                                            @RequestParam(name = "name", required = false) String name,
                                            @RequestParam(name = "species", required = false) String species,
                                            @RequestParam(name = "age", required = false) Integer age,
                                            @RequestParam(name = "gender", required = false) String gender,
                                            @RequestParam(name = "weight", required = false) Double weight) {
        Pet updatePet = Pet.builder().id(id)
                .ownerId(ownerId)
                .name(name)
                .species(species)
                .gender(gender)
                .age(age)
                .weight(weight).build();
        return ResponseEntity.accepted().body(petService.updatePet(updatePet));
    }
}
