package com.tts.studentExample;

import static org.assertj.core.api.Assertions.assertThat;

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
	
	@Before
	public void setUp() {
		ernest = new Student("Ernest", 2.5f, true);
	}
	
	@Test
	public void givenStudentId_returnStudent() {
		Mockito.when(studentRepository.findStudentById(1L)).thenReturn(ernest);
		
		Student found = studentService.getStudentUsingId(1L);
		
		assertThat(ernest).isEqualToComparingFieldByField(found);
	}

}
