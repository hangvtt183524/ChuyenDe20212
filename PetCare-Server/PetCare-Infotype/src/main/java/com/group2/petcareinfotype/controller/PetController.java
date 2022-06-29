package com.group2.petcareinfotype.controller;

import com.group2.petcareinfotype.entity.Pet;
import com.group2.petcareinfotype.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "v1/pet")
@Slf4j
public class PetController {
    @Autowired
    PetService petService;

    @PostMapping(value = "/searchByUser")
    public ResponseEntity<List<Pet>> searchAllByUser(@RequestParam(name = "userId", required = false) Long userId) {
        return ResponseEntity.accepted().body(petService.getAllPets(userId));
    }
}
