package com.group2.petcareinfotype.repository;

import com.group2.petcareinfotype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from user where username like %:username%", nativeQuery = true)
    public Optional<User> findUserByUsername(@Param("username") String username);

    @Query(value = "select * from user where mail like CONCAT('%', :mail,'%')", nativeQuery = true)
    public Optional<User> findFirstByMail(@Param("mail") String mail);
}
