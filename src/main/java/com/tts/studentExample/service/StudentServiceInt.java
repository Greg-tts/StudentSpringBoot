package com.tts.studentExample.service;

import java.util.ArrayList;

import com.tts.studentExample.model.Student;

// 3
public interface StudentServiceInt {

	// 8{
	public Student getStudentUsingId(Long id);
	//}

	public ArrayList<Student> getAll();
}
