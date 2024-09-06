package com.task2.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task2.springboot.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

	
	public Department findBydepartmentName(String departName);
	
	public Department findBydepartmentNameIgnoreCase(String departName);
	
}
