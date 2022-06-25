package com.group2.petcareinfotype.repository;

import com.group2.petcareinfotype.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
