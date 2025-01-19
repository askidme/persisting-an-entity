package com.codergm.sdj.service;

import com.codergm.sdj.entity.Student;
import com.codergm.sdj.repository.MyCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomStudentService {

    private final MyCustomRepository myCustomRepository;

    public List<Student> findAll() {
        return myCustomRepository.findAll();
    }
}
