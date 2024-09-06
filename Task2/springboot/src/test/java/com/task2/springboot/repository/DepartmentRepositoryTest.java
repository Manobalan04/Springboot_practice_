package com.task2.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.task2.springboot.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void SetUp() {
		Department department = Department.builder()
				.departmentName("eee")
				.departmentCode("3e")
				.departmentAddress("tvm")
				.build();
		
		entityManager.persist(department);
		
	}
	
	public void whenFindById_thenReturnDepartment() {
		Department department = departmentRepository.findById(102L).get();
		assertEquals(department.getDepartmentName(), "eee");
	}
	
}
