package com.mehdi.springboot3jwt.service.school;

import com.mehdi.springboot3jwt.auth.AuthenticationResponse;
import com.mehdi.springboot3jwt.config.JwtService;
import com.mehdi.springboot3jwt.entity.school.Student;
import com.mehdi.springboot3jwt.entity.school.StudentInfo;
import com.mehdi.springboot3jwt.repository.school.StudentInfoRepository;
import com.mehdi.springboot3jwt.repository.school.StudentRepository;
import com.mehdi.springboot3jwt.token.TokenEntity;
import com.mehdi.springboot3jwt.token.TokenRepository;
import com.mehdi.springboot3jwt.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService  {

    private final StudentRepository studentRepository;
    private final StudentInfoRepository studentInfoRepository;



    public StudentService(StudentRepository studentRepository, StudentInfoRepository studentInfoRepository) {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }

    // يمكنك إضافة المزيد من الحقول إلى ملف الطالب حسب الحاجة
    public Student createStudentProfile(String username, String password,
                                        String name, int age, String gradeLevel,String email
    ) {
        Student student = Student.builder()
                .username(username)
                .password(password)
                .name(name)
                .age(age)
                .gradeLevel(gradeLevel)
                .email(email)
                .build();

        // يمكنك إضافة المزيد من العمليات أو التحققات هنا

        return studentRepository.save(student);
    }



    public boolean login(String username, String password) {
        Student student = studentRepository.findByUsername(username);
        return student != null && student.getPassword().equals(password);
    }


    public boolean addStudentInfoById(Long studentId, String info, int points, String result) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            StudentInfo studentInfo = StudentInfo.builder()
                    .info(info)
                    .points(points) // النقاط
                    .result(result) // المادة
                    .student(student)
                    .build();

            studentInfoRepository.save(studentInfo);

            return true;
        }

        return false;
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }



}
