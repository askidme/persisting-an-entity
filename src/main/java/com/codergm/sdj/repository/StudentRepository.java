package com.codergm.sdj.repository;

import com.codergm.sdj.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    boolean existsByEnrollmentId(String enrollmentId);

    List<Student> findByName(String name, Sort sort);

    Page<Student> findByAgeGreaterThan(int age, Pageable pageable);
}
