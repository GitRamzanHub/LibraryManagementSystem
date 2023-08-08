package com.librarymanagementsystem.ramzan.resources;

import com.librarymanagementsystem.ramzan.entities.Book;
import com.librarymanagementsystem.ramzan.entities.Librarian;
import com.librarymanagementsystem.ramzan.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.librarymanagementsystem.ramzan.services.


@RestController
@RequestMapping("library/register")
public class RegistrationResources{

    @Autowired
    StudentService studentService;

    @Autowired
    LibrarianService librarianService;

    @Autowired
    BookService bookService;

    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

//  @PostMapping("/{type}")
//  public ResponseEntity<Object> addObject(@RequestBody Object obj, @PathVariable("type") String key) {
//    switch (key) {
//      case "student":
//        return new ResponseEntity<>(studentService.addStudent((Student) obj), HttpStatus.CREATED);
//      case "librarian":
//        return new ResponseEntity<>(librarianService.addLibrarian((Librarian) obj), HttpStatus.CREATED);
//      case "book":
//        return new ResponseEntity<>(bookService.addBook((Book) obj), HttpStatus.CREATED);
//      default:
//        return new ResponseEntity<>("Invalid Request: Wrong key provided, Should be one " +
//            "from [student,book,librarian]", HttpStatus.BAD_REQUEST);
//    }
//  }

    @PostMapping("/librarian")
    public ResponseEntity<Object> addLibrarian(@RequestBody Librarian librarian){
        return new ResponseEntity<>(librarianService.addLibrarian(librarian), HttpStatus.CREATED);
    }

    @PostMapping("/book")
    //public ResponseEntity<Object> addBookWithBookCount(@RequestBody Book theBook){
    public Book addBookWithBookCount(@RequestBody Book theBook){
//    Book dbBook = new Book();
//    // get all the books from DB
//    Iterable<Book> myAvailableBooks = new ArrayList<>();
//    myAvailableBooks = bookService.getAllBooks();
//
//    Iterator<Book> myIterator = myAvailableBooks.iterator();
//
//    // check if theBook match with any book in DB then increment the count of theBook
//    while (myIterator.hasNext()){
//      dbBook = myIterator.next();
//
//      if(dbBook.getName().equals(theBook.getName()) && dbBook.getAuthor().equals(theBook.getAuthor())){
//        theBook.setBookCount(dbBook.getBookCount()+1);
//        // update theBook object with incremented bookCount value in the DB
//        return bookService.addBook(theBook);
//      }
//    }
        return bookService.addBook(theBook);
    }



}