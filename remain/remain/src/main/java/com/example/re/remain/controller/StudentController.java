package com.example.re.remain.controller;

import com.example.re.remain.entity.StudentEntity;
import com.example.re.remain.service.DepartmentNameAlreadyExistsException;
import com.example.re.remain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveStudent(@RequestBody StudentEntity studentEntity){
    	HashMap<String,Object> response = new HashMap<>();
    	try {
            StudentEntity savedStudent = studentService.saveStudent(studentEntity);
            response.put("status","Your Data Stored");
            response.put("data", savedStudent);
            return ResponseEntity.ok(response);
        } catch(Exception e) {
        	response.put("status", HttpStatus.BAD_REQUEST);
        	response.put("message",e.getMessage());
        	return ResponseEntity.badRequest().body(response);
        }
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
    
    @GetMapping("/sort/{field}")
    private APIResponse<List<StudentEntity>> getDetailsWithSort(@PathVariable("field") String page){
    	List<StudentEntity> allDetails = studentService.fetchStudentWithSorting(page);
    	return new APIResponse<>(allDetails.size(), allDetails);
    }
    
    @GetMapping("/paging/{offset}/{pageSize}")
    private APIResponse<Page<StudentEntity>> getDetailsWithPaging(@PathVariable int offset, @PathVariable int pageSize){
    	Page<StudentEntity> allDetails = studentService.fetchStudentWithPaging(offset, pageSize);
    	return new APIResponse<>(allDetails.getSize(), allDetails);
    }
    
    @GetMapping("/pagingandsort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<StudentEntity>> getDetailsWithPagingAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
    	Page<StudentEntity> allDetails = studentService.fetchStudentWithPagingAndSorting(offset, pageSize, field);
    	return new APIResponse<>(allDetails.getSize(), allDetails);
    }
    


}
