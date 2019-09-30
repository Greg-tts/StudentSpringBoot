package com.tts.studentExample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.studentExample.model.Student;
import com.tts.studentExample.repository.StudentRepository;
import com.tts.studentExample.service.StudentServiceImpl;
import com.tts.studentExample.service.StudentServiceInt;

@RunWith(SpringRunner.class)
public class StudentServiceTest {
	
	@Configuration
	static class ServiceConfiguration{
		@Bean
		public StudentServiceInt configuration() {
			return new StudentServiceImpl();
		}
	}
	
	@Autowired
	StudentServiceInt studentService;
	
	@MockBean
	StudentRepository studentRepository;
	
	private static Student ernest;
	private static ArrayList<Student> studentList;
	
	@Before
	public void setUp() {
		ernest = new Student("Ernest", 2.5f, true);
		studentList = new ArrayList<>();
		studentList.add(ernest);
	}
	
	@Test
	public void givenStudentId_returnStudent() {
		Mockito.when(studentRepository.findStudentById(1L)).thenReturn(ernest);
		
		Student found = studentService.getStudentUsingId(1L);
		
		assertThat(ernest).isEqualToComparingFieldByField(found);
	}
	
	@Test
	public void ifFindAll_returnAllStudents(){
		Mockito.when(studentRepository.findAll()).thenReturn(studentList);
		ArrayList<Student> found = studentService.getAll();
		assertEquals(studentList, found);
	}

}
