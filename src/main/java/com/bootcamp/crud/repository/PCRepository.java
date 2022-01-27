package com.bootcamp.crud.repository;

import com.bootcamp.crud.model.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Use class as repository class
public interface PCRepository extends JpaRepository <PC, Integer> {
    PC findById (long id);
}
