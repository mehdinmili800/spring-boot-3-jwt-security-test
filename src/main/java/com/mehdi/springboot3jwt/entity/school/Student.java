package com.mehdi.springboot3jwt.entity.school;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String name;
    private int age;
    private String gradeLevel;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<StudentInfo> studentInfos;


}
