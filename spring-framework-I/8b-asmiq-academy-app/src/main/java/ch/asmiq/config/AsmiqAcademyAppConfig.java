package ch.asmiq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.karthi.certification.KarthiCertificationValidator;

@Configuration
public class AsmiqAcademyAppConfig {
	
	@Bean
	public KarthiCertificationValidator karthiCertificationValidator() {
		return new KarthiCertificationValidator();
	}
}
