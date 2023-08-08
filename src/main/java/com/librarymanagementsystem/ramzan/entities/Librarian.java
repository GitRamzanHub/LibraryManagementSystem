package com.librarymanagementsystem.ramzan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.sql.Update;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name="librarian_table")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "librarian_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID librarianId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contact;

    private int age;

    @JsonIgnore
    @OneToMany(mappedBy = "issuedBy", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BookAllocation> allocatedList;


}
