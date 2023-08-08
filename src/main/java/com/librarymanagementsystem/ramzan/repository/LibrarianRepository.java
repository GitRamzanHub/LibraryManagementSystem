package com.librarymanagementsystem.ramzan.repository;

import com.librarymanagementsystem.ramzan.entities.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, UUID> {


}
