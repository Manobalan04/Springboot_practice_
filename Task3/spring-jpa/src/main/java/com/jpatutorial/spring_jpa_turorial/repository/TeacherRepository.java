package com.jpatutorial.spring_jpa_turorial.repository;

import com.jpatutorial.spring_jpa_turorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
