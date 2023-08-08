package com.librarymanagementsystem.ramzan.services;

import com.librarymanagementsystem.ramzan.entities.*;
import com.librarymanagementsystem.ramzan.repository.BookAllocationRepository;
import com.librarymanagementsystem.ramzan.repository.BookRepository;
import com.librarymanagementsystem.ramzan.repository.LibrarianRepository;
import com.librarymanagementsystem.ramzan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.Duration;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookAllocationService {

    @Autowired
    BookAllocationRepository bookAllocationRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LibrarianRepository librarianRepository;

    // function to allocate books
    public BookAllocation allocateBook(AllocationRequest allocationRequest) {
        Optional<Book> book = bookRepository.findById(allocationRequest.getBookInf());
        Optional<Student> student = studentRepository.findById(allocationRequest.getAllocatedTo());
        Optional<Librarian> librarian = librarianRepository.findById(allocationRequest.getIssuedBy());

        if( book.isPresent() && student.isPresent() && librarian.isPresent()){
            return bookAllocationRepository.save(BookAllocation.builder().allocatedTo(student.get())
                    .issuedBy(librarian.get())
                    .issuedOnTimeStamp(System.currentTimeMillis() /1000)
                    .bookInf(book.get())
                    .build());
        } else{
            return null;
        }
    }

    // Get book allocation
    public BookAllocation getBookAllocation(UUID id){
        return bookAllocationRepository.findById(id).orElse(null);
    }

    // implementing return book from book allocation table
    public String returnBook(UUID alloationId){
        long penalty = 0;

        // taking bookAllocationRecord By bookallocationid
        BookAllocation allocatedBookRecord = bookAllocationRepository.getById(alloationId);

        if( allocatedBookRecord != null){
            //Checking book allocation date & return date

                // get Allocation date
            long bookAllocationDate = allocatedBookRecord.getIssuedOnTimeStamp();

                // get book Return Date
            long bookReturnDate = System.currentTimeMillis() / 1000;

                // finding difference between allocation date & return date;
            long diffInSec = bookReturnDate - bookAllocationDate;
            long diffInDays = Duration.ofSeconds(diffInSec).toDays();

                // checking if diff in days is greater than 7
            if(diffInDays > 7){
                allocatedBookRecord.setReturnedStatus(true);
                allocatedBookRecord.setReturTimeStamp(bookReturnDate);
                bookAllocationRepository.save(allocatedBookRecord);
            }else{
                // calculate dues per days * with 10 per days
                long duesDay = diffInDays - 7;
                // multiply duesDays with 10 Rs.
                penalty = duesDay * 10;

                allocatedBookRecord.setReturnedStatus(true);
                allocatedBookRecord.setReturTimeStamp(bookReturnDate);
                bookAllocationRepository.save(allocatedBookRecord);
            }
        }else{
            return "Can't get the record.";
        }

        return "book is returned successfully with Pentaly: " + penalty + " Rs.";
    }
}
