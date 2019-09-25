package com.tts.studentExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tts.studentExample.service.StudentServiceImpl;

// 1
@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
}
