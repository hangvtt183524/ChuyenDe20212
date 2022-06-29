package com.group2.petcareinfotype.repository;

import com.group2.petcareinfotype.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query(value = "select * from pet where owner_id = ?1", nativeQuery = true)
    public Optional<List<Pet>> findByOwnerId(@Param("owner_id") Long owner_id);
}
