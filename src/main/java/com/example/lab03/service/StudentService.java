package com.example.lab03.service;

import com.example.lab03.entity.Student;
import com.example.lab03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // GET ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // CREATE + UPDATE
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // DELETE
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    // SEARCH BY NAME
    public List<Student> findByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    public Student getById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

}
