package com.tts.studentExample.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
//	@GetMapping("/students/isinclub/{isInClub}")
//	public ArrayList<Student> getStudentsClub(@PathVariable Boolean isInClub){
//		return studentServiceImpl.getStudentsClubFilter(isInClub);
//	}
	
	@GetMapping("/students/isinclub")
	public ArrayList<Student> getStudentsClub(@RequestParam Boolean isInClub){
		return studentServiceImpl.getStudentsClubFilter(isInClub);
	}

	
	@PostMapping("/student")
	public void save(Student student) {
		studentServiceImpl.saveStudent(student);
	}
	
	@DeleteMapping("/students")
	public void deleteEverything() {
		studentServiceImpl.deleteAllStudents();
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentServiceImpl.deleteStudentUsingId(id);
	}
	
	@PutMapping("/student/{id}")
	public void updateStudent(@PathVariable Long id, Student student) {
		studentServiceImpl.updateStudent(id, student);
	}
	
}
