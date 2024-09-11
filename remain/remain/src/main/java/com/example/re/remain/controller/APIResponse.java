package com.example.re.remain.controller;

import com.example.re.remain.entity.StudentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {

	int RecordCount;
	T Student_Records;
}
