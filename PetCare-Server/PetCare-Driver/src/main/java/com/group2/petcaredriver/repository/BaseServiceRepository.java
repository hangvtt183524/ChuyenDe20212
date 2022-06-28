package com.group2.petcaredriver.repository;

import com.group2.petcaredriver.entity.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseServiceRepository extends JpaRepository<BaseService, Long> {
    @Query(value = "select * from service where code = :code", nativeQuery = true)
    public Optional<List<BaseService>> findBaseServicesByCode(@Param("code") Integer code);
}
