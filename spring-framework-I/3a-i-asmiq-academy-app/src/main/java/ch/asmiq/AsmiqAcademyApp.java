package ch.asmiq;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.asmiq.model.Customer;
import ch.asmiq.model.Order;
import ch.asmiq.service.AsmiqAcademyService;

public class AsmiqAcademyApp {

	private static final Logger LOG = Logger.getLogger(AsmiqAcademyApp.class.getName());

	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("asmiq-academy-app.xml");
		AsmiqAcademyService asmiqAcademyService = applicationContext.getBean(AsmiqAcademyService.class);

		var optJavaCourse = asmiqAcademyService.getCourses().stream().filter(p -> p.getName().contains("Java"))
				.findAny();

		if (optJavaCourse.isPresent()) {
			Order order = new Order();
			order.setCustomer(new Customer("karthi", "karthistr 6, 8051 Zürich"));
			order.setCourse(optJavaCourse.get());
			asmiqAcademyService.placeOrder(order);
		} else {
			LOG.info("No order has been placed!!");
		}
		
		applicationContext.close();
	}
}
