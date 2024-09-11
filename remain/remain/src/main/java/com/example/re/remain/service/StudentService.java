package com.example.re.remain.service;

import java.util.List;

import com.example.re.remain.entity.StudentEntity;

public interface StudentService{

    public StudentEntity saveStudent(StudentEntity studentEntity);

    public List<StudentEntity> fetchStudentList();

    public StudentEntity fetchStudentById(Long studentId);

    public void deleteStudentById(Long studentId);

    public StudentEntity updateStudentById(Long studentId, StudentEntity studentEntity);

    public List<StudentEntity> fetchStudentByName(String studentName);
    
    public List<StudentEntity> fetchDepartmentByName(String departmentName);
    
    public List<StudentEntity> fetchStudentByStudentPlace(String studentPlace);

	public List<StudentEntity> fetchDepartmentByCode(String departmentCode);


}
