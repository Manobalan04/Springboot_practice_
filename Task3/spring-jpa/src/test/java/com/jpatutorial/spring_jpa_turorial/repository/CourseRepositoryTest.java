package com.jpatutorial.spring_jpa_turorial.repository;

import com.jpatutorial.spring_jpa_turorial.entity.Course;
import com.jpatutorial.spring_jpa_turorial.entity.Student;
import com.jpatutorial.spring_jpa_turorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = "+ courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Mohan")
                .lastName("Raj")
                .build();

        Course course= Course.builder()
                .title("React")
                .credit(7)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("courses = "+ courses);

        System.out.println("totalElements = "+ totalElements);

        System.out.println("totalPages = "+ totalPages);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2,
                        Sort.by("title")
                );

        Pageable sortByCreditDesc =
                PageRequest.of(0,2,
                        Sort.by("credit").descending()
                );
        Pageable sortByTitleAndCredit =
                PageRequest.of(0,2,
                        Sort.by("title").descending().and(Sort.by("credit"))
                );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("vini")
                .lastName("th")
                .build();

        Student student = Student.builder()
                .firstName("hari")
                .lastName("haran")
                .emailId("hari@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}