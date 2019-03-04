package ch.asmiq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.CourseService;
import ch.asmiq.interfaces.NotificationService;
import ch.asmiq.model.Course;
import ch.asmiq.model.Order;

@Service
public class AsmiqAcademyService {

	private CourseService courseService;
	private NotificationService smsService;

	public AsmiqAcademyService(CourseService courseService, NotificationService notificationService) {
		this.courseService = courseService;
		this.smsService = notificationService;
	}

	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	public void placeOrder(Order order) {
		smsService.sendNotification(order);
	}

}
