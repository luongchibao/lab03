// package com.example.lab03.controller;

// import com.example.lab03.service.StudentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;

// @Controller
// public class StudentController {
//     @Autowired
//     private StudentService studentService;

//     @GetMapping("/students")
//     public String listStudents(Model model) {
//         model.addAttribute("students", studentService.getAllStudents());
//         return "students"; // students.html
//     }
// }
// package com.example.lab03.controller;

// import com.example.lab03.entity.Student;
// import com.example.lab03.repository.StudentRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/students")
// public class StudentController {

//     @Autowired
//     private StudentRepository repository;

//     // GET ALL
//     @GetMapping
//     public List<Student> getAllStudents() {
//         return repository.findAll();
//     }

//     @GetMapping("/search")
//     public List<Student> searchByName(@RequestParam String name) {
//         return repository.findByNameContainingIgnoreCase(name);
//     }

//     // POST
//     @PostMapping
//     public Student createStudent(@RequestBody Student student) {
//         return repository.save(student);
//     }

// }

package com.example.lab03.controller;

import com.example.lab03.entity.Student;
import com.example.lab03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // SEARCH BY NAME
    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    // ADD
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    // UPDATE
    @PostMapping("/update/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student updatedStudent) {

        Student student = repository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
        student.setEmail(updatedStudent.getEmail());

        return repository.save(student);
    }

    // DELETE
    @PostMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}