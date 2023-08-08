package com.librarymanagementsystem.ramzan.resources;

import com.librarymanagementsystem.ramzan.entities.AllocationRequest;
import com.librarymanagementsystem.ramzan.entities.BookAllocation;
import com.librarymanagementsystem.ramzan.exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.librarymanagementsystem.ramzan.services.BookAllocationService;

import java.util.UUID;

@RestController
@RequestMapping("library/")
public class LibraryResources {
    @Autowired
    BookAllocationService bookAllocationService;

    @PostMapping("allocation")
    public ResponseEntity<Object> alloccateBook(@RequestBody AllocationRequest allocationRequest) {
        BookAllocation bookAllocation = bookAllocationService.allocateBook(allocationRequest);

        if (bookAllocation == null) {
            throw new InvalidRequestException();
        }
        return new ResponseEntity<>(bookAllocation, HttpStatus.CREATED);
    }

    // Get Allocation By Student Id
    @GetMapping("allocation/get/{id}")
    public ResponseEntity<Object> getAllocation(@PathVariable("id") UUID id) {
        BookAllocation bookAllocation = bookAllocationService.getBookAllocation(id);

        if(bookAllocation == null){
            throw new InvalidRequestException();
        }
        return new ResponseEntity<>(bookAllocation, HttpStatus.FOUND);
    }

    // Implementing Return Book By Book Id
    @GetMapping("return/{allocationId}")
    public String returnBook(@PathVariable("allocationId") UUID allocationId){
        return bookAllocationService.returnBook(allocationId);
    }


}
