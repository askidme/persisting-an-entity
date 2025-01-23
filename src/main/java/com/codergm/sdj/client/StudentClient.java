package com.codergm.sdj.client;

import com.codergm.sdj.entity.Student;
import com.codergm.sdj.repository.StudentRepository;
import com.codergm.sdj.service.CustomStudentService;
import com.codergm.sdj.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@Component
@RequiredArgsConstructor
@Slf4j
public class StudentClient implements ApplicationRunner {

    private final StudentService service;
    private final CustomStudentService customStudentservice;
    private final StudentRepository repository;
    private final StudentRepository studentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student sampleStudent = new Student("John","XXYYZZ",15);
        createStudents(sampleStudent,119);
        long count = repository.count();
        int elementsPerPage = 10;
        int numberOfPages = (int) Math.ceil((double)count / (double)elementsPerPage);

        for(int i = 0; i < numberOfPages; i++){
            Slice<Student> studentPage = getPageStudents(20, i, elementsPerPage);
            log.info("page number: " + i);
            studentPage.forEach(student -> log.info(student.toString()));
        }
    }

    Slice<Student> getPageStudents(int age, int page, int elementNumbers){
        Pageable pageable = PageRequest.of(page, elementNumbers, Sort.by("name").descending());
        return repository.findByAgeGreaterThan(age,pageable);
    }

    void createStudents(Student student, int numberOfStudents){
        List<Student> students = IntStream.range(0,numberOfStudents).boxed()
                .map(i -> new Student( student.getName()+i,
                        student.getEnrollmentId()+i,
                        student.getAge() + i))
                .toList();
        studentRepository.saveAll(students);
    }
}
