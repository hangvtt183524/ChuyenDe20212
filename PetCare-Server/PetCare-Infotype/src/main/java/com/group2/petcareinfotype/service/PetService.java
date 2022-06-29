package com.group2.petcareinfotype.service;

import com.group2.petcareinfotype.entity.Pet;
import com.group2.petcareinfotype.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PetService {
    @Autowired
    PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getAllPets(final Long userId) {
        Optional<List<Pet>> optionalPets = petRepository.findByOwnerId(userId);
        if (!optionalPets.isPresent()) {
            throw new IllegalArgumentException("Error when get pet of user!");
        }

        return optionalPets.get();
    }

    public Pet ceatePet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Pet pet) {
        if (pet.getId() == null) {
            throw new IllegalArgumentException("No Doctor existed!");
        }
        Optional<Pet> optionalExistPet = petRepository.findById(pet.getId());
        if (!optionalExistPet.isPresent() || optionalExistPet.get() == null) {
            throw new IllegalArgumentException("No Doctor existed!");
        }

        return petRepository.save(pet);
    }
}
