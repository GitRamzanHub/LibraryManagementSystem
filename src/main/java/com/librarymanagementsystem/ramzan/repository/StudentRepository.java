package com.librarymanagementsystem.ramzan.repository;

import com.librarymanagementsystem.ramzan.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    
}
