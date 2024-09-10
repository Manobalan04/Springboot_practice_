package com.jpatutorial.spring_jpa_turorial.repository;

import com.jpatutorial.spring_jpa_turorial.entity.Course;
import com.jpatutorial.spring_jpa_turorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void  saveTeacher(){
        Course coursePython=Course.builder()
                .title("Python")
                .credit(4)
                .build();

        Course courseJava=Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacher= Teacher.builder()
                .firstName("Patthu")
                .lastName("Suriya")
                .courses(List.of(coursePython,courseJava))
                .build();

        teacherRepository.save(teacher);

    }
}