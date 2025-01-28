package com.codergm.sdj.service;

import com.codergm.sdj.entity.Student;
import com.codergm.sdj.repository.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT, timeout = -1, rollbackFor = Exception.class,
    readOnly = false)
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteUser(Long id) {
        studentRepository.deleteById(id);
        log.info("user by id {} deleted", id);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));
    }

    public boolean studentExists(Long id) {
        return studentRepository.existsById(id);
    }
}
