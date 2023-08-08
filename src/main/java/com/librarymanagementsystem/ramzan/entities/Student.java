package com.librarymanagementsystem.ramzan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name="student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "student_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID studentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contact;

    private String branch;

    private String accountStatus = "ACTIVE";

    private Long registrationTimeStamp = System.currentTimeMillis() / 1000;

    @Column(nullable = false)
    private Long updateTimeStamp = System.currentTimeMillis() / 1000;

    private int age;

    @JsonIgnore
    @OneToMany(mappedBy = "allocatedTo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BookAllocation> allocatedBooks;

}
