package com.codergm.sdj.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@ToString
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "enrollment_id", nullable = false, unique = true)
    private String enrollmentId;

    private int age;

    public Student(String name, String enrollmentId, int age) {
        this.name = name;
        this.enrollmentId = enrollmentId;
        this.age = age;
    }
}
