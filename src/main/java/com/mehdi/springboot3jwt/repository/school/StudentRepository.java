package com.mehdi.springboot3jwt.repository.school;

import com.mehdi.springboot3jwt.entity.school.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {

    Student findByUsername(String username);

}
