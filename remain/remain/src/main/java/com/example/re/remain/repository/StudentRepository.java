package com.example.re.remain.repository;

import com.example.re.remain.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    public List<StudentEntity> findBystudentName(String studentName);
    
    public List<StudentEntity> findBydepartmentName(String departmentName);
    
    public List<StudentEntity> findBystudentPlace(String studentPlace);

    public StudentEntity findBystudentNameIgnoreCase(String studentName);
    
    public StudentEntity existsBystudentName(String studentName);
    
    public List<StudentEntity> findBydepartmentCode(String departmentCode);
    
    boolean existsByStudentName(String studentName);

}
