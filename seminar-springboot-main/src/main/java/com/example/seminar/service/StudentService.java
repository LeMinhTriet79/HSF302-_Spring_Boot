package com.example.seminar.service;

import com.example.seminar.entity.Student;
import com.example.seminar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    //lấy một danh sách sinh viên

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public  Student createNewStudent(Student student) {
        return studentRepository.save(student);
    }
    //
}
