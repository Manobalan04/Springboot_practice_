package com.example.re.remain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( 
		name = "student_entity",
		uniqueConstraints = @UniqueConstraint(
				name = "studentName_unique",
				columnNames = "student_name")
		)
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    
    @Column(
    		name = "student_name",
    		nullable = false
    		)
    private String studentName;
    private String studentPlace;
    private String departmentCode;
    private String departmentName;

}
