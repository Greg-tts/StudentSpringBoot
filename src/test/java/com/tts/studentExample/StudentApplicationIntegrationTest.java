package com.tts.studentExample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;


import com.tts.studentExample.model.Student;
import com.tts.studentExample.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK,
		classes = StudentExampleApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integrationtest.properties" )
public class StudentApplicationIntegrationTest {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private MockMvc mvc;
	
	private Student ernest;
	
	@Before
	public void setUp() {
		ernest = new Student("Ernest", 2.5f, true);
		studentRepository.save(ernest);
	}
	
	@After
	public void tearDown() {
		studentRepository.delete(ernest);
	}
	
	@Test
	public void givenStudentId_getStudent_returnsStudent() throws Exception{
		Long studentId = ernest.getId();
		
		mvc.perform(get("/student/" + studentId).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name", is("Ernest")));
	}
	
	@Test
	public void findAll_returnsAllStudents() throws Exception{
		
		mvc.perform(get("/students").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].name", is("Ernest")));
	}

}
