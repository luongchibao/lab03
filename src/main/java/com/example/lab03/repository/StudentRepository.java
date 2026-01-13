package com.example.lab03.repository;

import com.example.lab03.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {
        
        List<Student> findByNameContainingIgnoreCase(String name);
}