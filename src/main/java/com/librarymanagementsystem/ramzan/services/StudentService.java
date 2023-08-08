package com.librarymanagementsystem.ramzan.services;

import com.librarymanagementsystem.ramzan.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    com.librarymanagementsystem.ramzan.repository.StudentRepository studentRepository;

    // Create & Save Student to DB
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    // Get List of Student
    public Iterable<Student> listStudent(){
        return studentRepository.findAll();
    }

    // Get Student By Id
    public Optional<Student> getStudentById(UUID studentId){
        return studentRepository.findById(studentId);
    }


}
