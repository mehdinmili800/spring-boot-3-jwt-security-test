package com.mehdi.springboot3jwt.repository.school;


import com.mehdi.springboot3jwt.entity.school.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {
    // Add specific queries if needed
}
