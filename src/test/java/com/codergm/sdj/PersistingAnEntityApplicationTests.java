package com.codergm.sdj;

import com.codergm.sdj.entity.Student;
import com.codergm.sdj.repository.StudentRepository;
import com.codergm.sdj.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


//@SpringBootTest
class PersistingAnEntityApplicationTests {

//    @Autowired
    private  StudentService studentService;

//    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testCrud(){

        //Create
        Student student = new Student("Alisa Simmons", "2022AN50123",10);
        Student returnedStudent = studentService.saveStudent(student);
        assertThat(returnedStudent.getId()).isNotNull();

        //Update
        returnedStudent.setName("Alissa Simmons");
        Student updatedStudent = studentService.saveStudent(returnedStudent);
        assertThat(updatedStudent.getName()).isEqualTo("Alissa Simmons");

        //Read
        Student foundStudent = studentService.getStudentById(returnedStudent.getId());
        assertThat(foundStudent.getId()).isSameAs(1L);

        //Delete
        studentService.deleteUser(foundStudent.getId());
        assertThat(studentService.studentExists(1L)).isFalse();
    }

    @Test
    void test_find_By_name(){
        //Arrange
        Student student = generateStudent();
        studentService.saveStudent(student);

        //Act
        List<Student> students = studentRepository.findByName("Alisa Simmons");

        //Assert

        assertThat(students.size()).isSameAs(1);
        assertThat(students.get(0).getName()).isEqualTo("Alisa Simmons");

    }

    @Test
    void test_find_all_students_sortable(){
        //Arrange
        List<Student> students = IntStream.range(0,10).boxed()
                .map(i -> new Student( "Name"+i,"enrollmentId"+i, 25 + i))
                .collect(Collectors.toList());
        studentRepository.saveAll(students);
        Sort sort = Sort.by(Sort.Direction.DESC, "name");

        //Act
        List<Student> studentsSorted = studentRepository.findAll(sort);

        //Assert
        assertThat(studentsSorted.size()).isSameAs(students.size());
        assertThat(studentsSorted.get(0)).isEqualTo(students.get(students.size()-1));

    }

    @Test
    void test_find_by_age_greater_pageable(){

        //Arrange

        int pageNumber = 0;
        int pageSize = 10;
        List<Student> students = IntStream.rangeClosed(1,103).boxed()
                .map(i -> new Student( "Name"+i,"enrollmentId"+i, 25 + i))
                .collect(Collectors.toList());
        studentRepository.saveAll(students);

        //Act
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Student> studentsPage = studentRepository.findAll(pageable);

        List<Student> pageStudents = studentsPage.getContent();
        int totalPages = studentsPage.getTotalPages();
        long totalElements = studentsPage.getTotalElements();

        //Assert
        assertThat(pageStudents.size()).isSameAs(10);
        assertThat(totalPages).isEqualTo(11);
        assertThat(totalElements).isEqualTo(103);




    }


    private Student generateStudent(){
        return new Student("Alisa Simmons", "2022AN50123",10);
    }



}
