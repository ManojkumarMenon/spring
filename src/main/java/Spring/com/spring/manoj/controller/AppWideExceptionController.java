package Spring.com.spring.manoj.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import Spring.com.spring.manoj.Exceptions.SpittleNotFoundException;

@ControllerAdvice
public class AppWideExceptionController {
	private Logger logger = Logger
			.getLogger("AppWideExceptionController.class");

	@ExceptionHandler(SpittleNotFoundException.class)
	public String handleSpittleNotFoundException() {
		logger.info("Caught SpittleNotFoundException");
		return "Exception/SpittleNotFoundException";
	}
}
