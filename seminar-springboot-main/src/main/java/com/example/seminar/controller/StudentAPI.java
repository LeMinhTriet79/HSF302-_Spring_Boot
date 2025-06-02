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
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @Valid @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudentById(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/student/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudentById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Controller --> nhận điều hướng request
    //service --> xử lý logic

}
