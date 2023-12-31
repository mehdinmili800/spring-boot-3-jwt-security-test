package com.mehdi.springboot3jwt.manager;

import com.mehdi.springboot3jwt.entity.school.Student;
import com.mehdi.springboot3jwt.entity.school.StudentInfo;
import com.mehdi.springboot3jwt.service.school.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
@PreAuthorize("hasRole('MANAGER')")
public class ManagerController {

    private final StudentService studentService;

    public ManagerController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create-student")
    @PreAuthorize("hasAuthority('manager:create')")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudentProfile(
                student.getUsername(),
                student.getPassword(),
                student.getName(),
                student.getAge(),
                student.getGradeLevel(),
                student.getEmail()
                );
        if (createdStudent != null) {
            return ResponseEntity.ok("Student profile created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create student profile");
        }
    }




    @PostMapping("/add-info/{studentId}")
    @PreAuthorize("hasAuthority('manager:create')")
    public ResponseEntity<String> addInfoToStudent(@PathVariable Long studentId, @RequestParam String info,
                                                   @RequestParam int points, @RequestParam String result) {
        boolean added = studentService.addStudentInfoById(studentId, info, points, result);
        if (added) {
            return ResponseEntity.ok("Information added to student successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

}