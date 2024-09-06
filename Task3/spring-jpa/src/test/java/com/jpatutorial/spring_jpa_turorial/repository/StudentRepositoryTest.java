package com.jpatutorial.spring_jpa_turorial.repository;

import com.jpatutorial.spring_jpa_turorial.entity.Guardian;
import com.jpatutorial.spring_jpa_turorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("po@gmail.com")
                .firstName("poksh")
                .lastName("siva")
//                .guardianName("balan")
//                .guardianEmail("posh@gmail.com")
//                .guardianMobile("123456")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){


        Guardian guardian = Guardian.builder()
                .guardianEmail("diesh@gmail.com")
                .guardianName("pokes")
                .guardianMobile("1234789")
                .build();

        Student student = Student.builder()
                .firstName("poki")
                .emailId("diesh@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students = studentRepository.findByFirstName("mano");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students = studentRepository.findByFirstNameContaining("p");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students = studentRepository.findByGuardianGuardianName("pokes");

        System.out.println("Students = "+ students);
    }

    @Test
    public void printStudentByEmailAddress(){

        Student student = studentRepository.getStudentByEmailAddress("mano@gmail.com");

        System.out.println("Students = "+ student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){

        String firstName = studentRepository.getStudentFirstNameByEmailAddress("mano@gmail.com");

        System.out.println("Student_First_Name = "+ firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("mano@gmail.com");

        System.out.println("Student = "+ student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("mano@gmail.com");

        System.out.println("Student = "+ student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "pokesh",
                "diesh@gmail.com"
        );
    }

}