package com.tts.studentExample.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tts.studentExample.model.Student;
import com.tts.studentExample.service.StudentServiceImpl;

// 1
@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	// 6 {
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentServiceImpl.getStudentUsingId(id);
	}
	//}
	
	@GetMapping("/students")
	public ArrayList<Student> getAllStudents(){
		return studentServiceImpl.getAll();
	}
	
}
