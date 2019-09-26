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

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}

	@Override
	public void deleteStudentUsingId(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public ArrayList<Student> getStudentsClubFilter(Boolean isInClub) {
		return studentRepository.findAllStudentsByIsInClub(isInClub);
	}

	@Override
	public void updateStudent(Long id, Student studentChanges) {
		Student currentStudent = studentRepository.findStudentById(id);
		// Get all changes from given Student
		Float gpa = studentChanges.getGpa();
		String name = studentChanges.getName();
		Boolean isInClub = studentChanges.getIsInClub();
		
		// Set all changes to current Student
		currentStudent.setGpa(gpa);
		currentStudent.setName(name);
		currentStudent.setIsInClub(isInClub);
		studentRepository.save(currentStudent);
	}
	
}
