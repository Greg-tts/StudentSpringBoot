package com.tts.studentExample.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.studentExample.model.Student;
import com.tts.studentExample.repository.StudentRepository;
//4
@Service
public class StudentServiceImpl implements StudentServiceInt{
	
	@Autowired
	private StudentRepository studentRepository;
//	7{
	@Override
	public Student getStudentUsingId(Long id) {
		return studentRepository.findStudentById(id);
	}
//	}
	
	@Override
	public ArrayList<Student> getAll(){
		return studentRepository.findAll();
	}
	
}
