package com.example.re.remain.service;

import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.re.remain.controller.StudentNameAlreadyExistsException;
import com.example.re.remain.entity.StudentEntity;
import com.example.re.remain.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity saveStudent(StudentEntity studentEntity) {
    	if (!studentRepository.findBystudentName(studentEntity.getStudentName()).isEmpty()) {
            throw new StudentNameAlreadyExistsException("Student name already exists: " + studentEntity.getStudentName());
        }
    	if (!studentRepository.findBydepartmentName(studentEntity.getDepartmentName()).isEmpty()) {
            throw new DepartmentNameAlreadyExistsException("Department name already exists: " + studentEntity.getDepartmentName());
        }
    	
        return studentRepository.save(studentEntity);
    }
    
   
    
    @Override
	public List<StudentEntity> fetchStudentList() {
		return studentRepository.findAll();
	}

    @Override
    public StudentEntity fetchStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
	public List<StudentEntity> fetchDepartmentByCode(String departmentCode) {
    	return studentRepository.findBydepartmentCode(departmentCode);
	}
    
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    
    

    @Override
    public StudentEntity updateStudentById(Long studentId, StudentEntity studentEntity) {
        StudentEntity reDB = studentRepository.findById(studentId).get();

        if(Objects.nonNull(studentEntity.getStudentName())&&
        !"".equalsIgnoreCase(studentEntity.getStudentName())){
        	
            reDB.setStudentName(studentEntity.getStudentName());
        }

        if(Objects.nonNull(studentEntity.getStudentPlace())&&
                !"".equalsIgnoreCase(studentEntity.getStudentPlace())){
            reDB.setStudentPlace(studentEntity.getStudentPlace());
        }

        return studentRepository.save(reDB);
    }


    @Override
    public List<StudentEntity> fetchStudentByName(String studentName) {
        return studentRepository.findBystudentName(studentName);
    }

	@Override
	public List<StudentEntity> fetchDepartmentByName(String departmentName) {
		return studentRepository.findBydepartmentName(departmentName);
	}

	@Override
	public List<StudentEntity> fetchStudentByStudentPlace(String studentPlace) {
		return studentRepository.findBystudentPlace(studentPlace);
	}



	@Override
	public List<StudentEntity> fetchStudentWithSorting(String page) {
		return studentRepository.findAll(Sort.by(Sort.Direction.ASC,page));
	}



	@Override
	public Page<StudentEntity> fetchStudentWithPaging(int offset, int pageSize) {
		 Page<StudentEntity> all = studentRepository.findAll(PageRequest.of(offset, pageSize));
		 return all;
	}
	
	@Override
	public Page<StudentEntity> fetchStudentWithPagingAndSorting(int offset, int pageSize, String page) {
		 Page<StudentEntity> all = studentRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.DESC, page)));
		 return all;
	}



}
