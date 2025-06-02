package com.example.seminar.controller;

import com.example.seminar.entity.Student;
import com.example.seminar.repository.StudentRepository;
import com.example.seminar.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Nơi tiếp nhận các request...
public class StudentAPI {

    //LẤY LÀ GET
    //GET: /api/student

    //POST ~ CREATE NEW
    //POST: /api/student

    //PUT ~ UPDATE
    //PUT: /api/student/id --> cần phải biết cái nào, ai, thông qua id
    //PATCH ---> Cập nhật một trường nào đó cụ thể

    //DELETE
    //DELETE: /api/student/id
    //--> nó giống PUT ~ UPDATE, cần phải chỉ rõ cụ thể, đâu đó rõ ràng, không có nói chung chung

    //ORM
    //Controller --> service --> repo

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @GetMapping("/api/student")
    public ResponseEntity getStudent() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/api/student")
    public ResponseEntity createNewStudent(@Valid @RequestBody Student student) {
        Student newStudent = studentService.createNewStudent(student);
        return ResponseEntity.ok(newStudent);
    }


    @PutMapping("/api/student/{id}")
    public String updateStudentById() {
        return "Update Student";
    }

    @DeleteMapping("/api/student/{id}")
    public String deleteStudentById() {
        return "Delete Student";
    }

    //Controller --> nhận điều hướng request
    //service --> xử lý logic

}
