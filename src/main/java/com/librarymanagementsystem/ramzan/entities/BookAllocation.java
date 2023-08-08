package com.librarymanagementsystem.ramzan.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book_allocation_table")
public class BookAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "book_allocation_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID bookAllocation;

    @JoinColumn(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "student_id")
    @JsonBackReference
    @ManyToOne(optional = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private Student allocatedTo;

    @JoinColumn(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "book_id")
    @ManyToOne(optional = false)
    @JsonBackReference
    @Type(type = "org.hibernate.type.UUIDCharType")
    private Book bookInf;

    @JoinColumn(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "librarian_id")
    @JsonBackReference
    @ManyToOne(optional = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private Librarian issuedBy;

    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "issued_on")
    private Long issuedOnTimeStamp = System.currentTimeMillis() / 1000; // epoch timestamp

    @Column(nullable = false, name = "returned_status")
    private boolean returnedStatus = false;

    @Column(columnDefinition = "VARCHAR(36)", name = "return_on")
    private Long returTimeStamp; // epoch Timestamp







}
