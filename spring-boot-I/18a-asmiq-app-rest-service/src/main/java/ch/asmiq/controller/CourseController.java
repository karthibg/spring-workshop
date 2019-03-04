package ch.asmiq.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.asmiq.model.Course;
import ch.asmiq.service.AsmiqAcademyService;

@RestController
public class CourseController {
	
	private AsmiqAcademyService asmiqAcademyService;

	public CourseController(AsmiqAcademyService asmiqAcademyService) {
		this.asmiqAcademyService = asmiqAcademyService;
	}

	@GetMapping(value="/courses", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Course>> courses() {
		return ResponseEntity.ok().body(asmiqAcademyService.getCourses());
	}

}
