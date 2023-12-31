package com.mehdi.springboot3jwt.student;


import com.mehdi.springboot3jwt.entity.school.Student;
import com.mehdi.springboot3jwt.entity.school.StudentInfo;
import com.mehdi.springboot3jwt.service.school.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student student) {
        if (studentService.login(
                student.getUsername(),
                student.getPassword()
        )) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }



}
