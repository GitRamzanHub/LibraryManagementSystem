package com.librarymanagementsystem.ramzan.resources;

import com.librarymanagementsystem.ramzan.entities.Book;
import com.librarymanagementsystem.ramzan.entities.Student;
import com.librarymanagementsystem.ramzan.services.BookAllocationService;
import com.librarymanagementsystem.ramzan.services.BookService;
import com.librarymanagementsystem.ramzan.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library/view")
public class ViewResources {

    @Autowired
    StudentService studentService;

    @Autowired
    BookAllocationService bookAllocationService;

    @Autowired
    BookService bookService;


    // get All Student
    @GetMapping("/students")
    public Iterable<Student> getStudent(){
        Iterable<Student> myList = new ArrayList<>();
        myList = this.studentService.listStudent();
        return myList;
    }


    // Get All the Books
    @GetMapping("/book")
    public Iterable<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    // Get All Books With Number of Copies Available

    @GetMapping("/bookCount")
    public Map<String, Long> getBookCount(){
        Book dbBook;
        HashMap<Integer, String> myHashMap = new HashMap<>();
        List<Book> myBooks =(List<Book>) bookService.getAllBook();

        for(int i=0; i<myBooks.size(); i++){
            dbBook = myBooks.get(i);
            myHashMap.put(i, dbBook.getName() + " By " +dbBook.getAuthor());
        }

        Map<String, Long> values = myHashMap.values().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return values;
    }

}
