package ch.asmiq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ch.asmiq.interfaces.CourseService;
import ch.asmiq.interfaces.NotificationService;
import ch.asmiq.service.OnlineCourseService;
import ch.asmiq.service.SmsService;

@Configuration
public class AsmiqAcademyAppConfig {
	

	@Primary
	@Bean
	public NotificationService smsService() {
		return new SmsService();
	}
	
	@Primary
	@Bean
	public CourseService courseService() {
		return new OnlineCourseService();
	}
	
}



