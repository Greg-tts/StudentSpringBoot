package com.tts.studentExample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK,
		classes = StudentExampleApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integrationtest.properties" )

public class StudentApplicationIntegrationTest {

	@Test
	public void contextLoads() {
	}

}
