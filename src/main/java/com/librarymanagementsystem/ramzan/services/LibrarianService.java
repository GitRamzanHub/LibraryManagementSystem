package com.librarymanagementsystem.ramzan.services;

import com.librarymanagementsystem.ramzan.entities.Librarian;
import com.librarymanagementsystem.ramzan.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {

    @Autowired
    LibrarianRepository librarianRepository;

    // save Librarian
    public Librarian addLibrarian(Librarian librarian){
        return librarianRepository.save(librarian);
    }
}
