package ch.asmiq.service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.ExamService;
import ch.asmiq.model.Order;

@Service
public class PrometricExamService implements ExamService{
	
	private static final Logger LOG = Logger.getLogger(PrometricExamService.class.getName());

	private  LocalDateTime examStartDateTime = LocalDateTime.now();
	
	@Override
	public void conductExam(Order order) {
		LOG.info("Exam for the order started at:"+examStartDateTime);
	}
	
	

}
