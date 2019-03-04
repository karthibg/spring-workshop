package ch.asmiq;

import java.util.logging.Logger;

public class GreetingService {

	private static final Logger LOG = Logger.getLogger(GreetingService.class.getName());

	private String helloString;

	public GreetingService(String helloString) {
		this.helloString = helloString;
	}

	public void sayHello() {
		LOG.info(helloString);
	}

}
