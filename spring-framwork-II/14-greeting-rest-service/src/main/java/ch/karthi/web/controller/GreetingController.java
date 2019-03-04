package ch.karthi.web.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

	@GetMapping("/hello")
	public String greet() {
		String message = "Welcome HBT :-) &#x1f605" + toSurrogates(0x1f605);
		LOG.info(message);
		return message;
	}

	@GetMapping("/hello/{name}")
	public String greetWith(@PathVariable String name) {
		return "Welcome " + name;
	}

	private static String toSurrogates(final int orig) {
		return new String(new char[] { Character.highSurrogate(orig), Character.lowSurrogate(orig) });
	}
}
