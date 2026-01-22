// package com.example.lab03.api;

// import com.example.lab03.entity.Student;
// import com.example.lab03.service.StudentService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/students")
// public class StudentApiController {

//     @Autowired
//     private StudentService studentService;

//     // 🔍 GET ALL
//     @GetMapping
//     public List<Student> getAll() {
//         return studentService.getAllStudents();
//     }

//     // ➕ CREATE
//     @PostMapping
//     public Student create(@RequestBody Student student) {
//         return studentService.save(student);
//     }

//     // ❌ DELETE
//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable int id) {
//         studentService.deleteById(id);
//     }

//     // ✏️ UPDATE
//     @PutMapping("/{id}")
//     public Student update(@PathVariable int id,
//                           @RequestBody Student student) {
//         student.setId(id);
//         return studentService.save(student);
//     }

//     // 🔍 SEARCH BY NAME 
//     @GetMapping("/search")
//     public List<Student> search(@RequestParam String name) {
//         return studentService.findByName(name);
//     }
// }

package com.example.lab03.api;

import com.example.lab03.entity.Student;
import com.example.lab03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @Autowired
    private StudentService studentService;

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    //THÊM SINH VIÊN
    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.save(student);
    }

    //CẬP NHẬT SINH VIÊN
    @PostMapping("/update/{id}")
    public Student update(@PathVariable int id,
                          @RequestBody Student student) {
        student.setId(id);
        return studentService.save(student);
    }

    // XÓA SINH VIÊN
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentService.deleteById(id);
    }

    // LẤY SINH VIÊN THEO ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    // TÌM KIẾM SINH VIÊN
    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentService.findByName(name);
    }
}
