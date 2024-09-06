package com.jpatutorial.spring_jpa_turorial.repository;

import com.jpatutorial.spring_jpa_turorial.entity.Course;
import com.jpatutorial.spring_jpa_turorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void SaveCourseMaterial(){
        Course course = Course.builder()
                .title(".Net")
                .credit(8)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.onetwo.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterial = repository.findAll();

        System.out.println("courseMaterials =" + courseMaterial);
    }

}