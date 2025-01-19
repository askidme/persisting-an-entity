package com.codergm.sdj.repository;

import com.codergm.sdj.entity.Student;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MyCustomRepository extends Repository<Student, Long> {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

}
