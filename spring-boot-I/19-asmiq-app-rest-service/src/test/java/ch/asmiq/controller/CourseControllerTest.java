package ch.asmiq.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ch.asmiq.model.Course;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CourseControllerTest {

	@LocalServerPort
	int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getCourses_returns_http_status_OK() {
		ResponseEntity<Course[]> courses = testRestTemplate.getForEntity("http://localhost:" + port + "/courses",
				Course[].class);

		assertThat("Call to '/courses' returns HttpStatus.OK", courses.getStatusCode(), is(HttpStatus.OK));

	}

}
