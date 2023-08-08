package com.librarymanagementsystem.ramzan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="books_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "book_id")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID bookId;

    @Type(type = "")
    private UUID nameId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @JsonIgnore
    @OneToMany(mappedBy = "bookInf", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BookAllocation> allocatedTo;
}
