package com.example.seminar.repository;

import com.example.seminar.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//giúp tương tác với database
public interface StudentRepository  extends JpaRepository<Student, Long> {

}
