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
    // Cập nhật sinh viên theo id
    public Student updateStudentById(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFullName(updatedStudent.getFullName());
                    student.setStudentCode(updatedStudent.getStudentCode());
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

    // Xóa sinh viên theo id
    public boolean deleteStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return true;
                })
                .orElse(false);
    }
}
