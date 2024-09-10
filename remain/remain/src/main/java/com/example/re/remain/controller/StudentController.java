package com.example.re.remain.controller;

import com.example.re.remain.entity.StudentEntity;
import com.example.re.remain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity){
        return studentService.saveStudent(studentEntity);
    }

    @GetMapping("/list")
    public List<StudentEntity> fetchStudentList(){
        return studentService.fetchStudentList();
    }

    @GetMapping("/student/id/{id}")
    public StudentEntity fetchStudentById(@PathVariable("id")Long studentId){
        return studentService.fetchStudentById(studentId);
    }
    
    @GetMapping("/depart/code/{id}")
    public List<StudentEntity> fetchDepartmentByCode(@PathVariable("id")String departmentCode){
        return studentService.fetchDepartmentByCode(departmentCode);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable("id")Long studentId){
        studentService.deleteStudentById(studentId);
        return "deleted";
    }

    @PutMapping("/update/{id}")
    public StudentEntity updateStudentById(@PathVariable("id") Long studentId,
                                     @RequestBody StudentEntity studentEntity){
        return studentService.updateStudentById(studentId, studentEntity);
    }

    @GetMapping("/student/name/{name}")
    public List<StudentEntity> fetchStudentByName(@PathVariable("name") String studentName) {
        return studentService.fetchStudentByName(studentName);
    }
    
    @GetMapping("/depart/name/{dep}")
    public List<StudentEntity> fetchDepartmentByName(@PathVariable("dep") String departmentName) {
        return studentService.fetchDepartmentByName(departmentName);
    }
    
    @GetMapping("/place/name/{location}")
    public List<StudentEntity> fetchStudentByStudentPlace(@PathVariable("location") String studentPlace) {
        return studentService.fetchStudentByStudentPlace(studentPlace);
    }


}
