package com.librarymanagementsystem.ramzan.services;

import com.librarymanagementsystem.ramzan.entities.Book;
import com.librarymanagementsystem.ramzan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // save & return single book
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    // get All Book from DB

    public Iterable<Book> getAllBook(){
        return bookRepository.findAll();
    }

    // Search Book By BookName
    public Iterable<Book> getBookByName(String bookName){
        Iterable<Book> dbBook = bookRepository.findAll();
        List<Book> tempBook = new ArrayList<>();

        for(Object ob : dbBook){
            tempBook.add((Book)ob);
        }
        return tempBook.stream().filter(d -> d.getClass().getName().toLowerCase().contains(bookName.toLowerCase())).collect(Collectors.toList());
    }
}
