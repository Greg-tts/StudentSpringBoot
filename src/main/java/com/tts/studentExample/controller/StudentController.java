package com.tts.studentExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.studentExample.model.Student;
import com.tts.studentExample.service.StudentServiceImpl;

// 1
@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	// 6 {
	@GetMapping("/student/1")
	public Student index() {
		return studentServiceImpl.getStudentUsingId(1L);
	}
	//}
}
