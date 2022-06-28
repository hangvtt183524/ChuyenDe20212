package com.group2.petcareinfotype.service;

import com.group2.petcareinfotype.entity.Pet;
import com.group2.petcareinfotype.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public List<Pet> getAllPets(final Long userId) {
        Optional<List<Pet>> optionalPets = petRepository.findByOwnerId(userId);
        if (!optionalPets.isPresent()) {
            throw new IllegalArgumentException("Error when get pet of user!");
        }

        return optionalPets.get();
    }
}
