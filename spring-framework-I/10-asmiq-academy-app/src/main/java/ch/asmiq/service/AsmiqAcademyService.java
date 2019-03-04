package ch.asmiq.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.CertificationService;
import ch.asmiq.interfaces.CourseService;
import ch.asmiq.interfaces.ExamService;
import ch.asmiq.interfaces.FeedbackService;
import ch.asmiq.interfaces.NotificationService;
import ch.asmiq.interfaces.PaymentService;
import ch.asmiq.model.Course;
import ch.asmiq.model.Order;

@Service
public class AsmiqAcademyService {

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyService.class.getName());

	private CourseService courseService;
	private NotificationService notificationService;
	private PaymentService paymentService;
	private FeedbackService feedBackService;
	private ExamService examService;
	private CertificationService certificationService;

	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	public void placeOrder(Order order) {
		notificationService.sendNotification(order);
		paymentService.doPay(order);
	}

	public CourseService getCourseService() {
		return courseService;
	}

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}

	@Autowired
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	@Autowired
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public FeedbackService getFeedBackService() {
		return feedBackService;
	}

	@Autowired
	public void setFeedBackService(FeedbackService feedBackService) {
		this.feedBackService = feedBackService;
	}

	public ExamService getExamService() {
		return examService;
	}

	@Autowired
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public CertificationService getCertificationService() {
		return certificationService;
	}

	@Autowired(required = false)
	public void setCertificationService(CertificationService certificationService) {
		this.certificationService = certificationService;
	}

	@PreDestroy
	public void cleanUp() {
		System.out.println("cleaning up... please wait for 45 Seconds...");
		sleep();
		System.out.println("shutting down");
	}

	private void sleep() {
		try {
			TimeUnit.SECONDS.sleep(45);
		} catch (InterruptedException e) {
			LOG.log(Level.WARNING, "Interrupted!", e);
			Thread.currentThread().interrupt();
		}
	}
}
