package com.mehdi.springboot3jwt.entity.school;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String info;
    private int points; // النقاط
    private String result; // المادة

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
