package Spring.com.spring.manoj.controller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Spring.com.spring.manoj.Exceptions.SpittleNotFoundException;
import Spring.com.spring.manoj.bean.Spittles;
import Spring.com.spring.manoj.bean.User;
import Spring.com.spring.manoj.repository.SpittlesRepository;

@Controller
public class HomeController {

	private Logger logger = Logger.getLogger("HomeController.java");
	@Autowired
	private SpittlesRepository spittlesRepository;

	@RequestMapping(value = "/")
	public String homePage() {
		logger.info("In homepage method");
		return "Home";
	}

	@RequestMapping(value = "/Spittles")
	public String RegisterRequestParam(
			@RequestParam(value = "startvalue", defaultValue = "0") int startvalue,
			@RequestParam(value = "endvalue", defaultValue = "20") int endvalue,
			Model model) {
		logger.info("In spittle method --> start value:-" + startvalue
				+ " and end value:- " + endvalue);
		model.addAttribute("spittleList",
				spittlesRepository.getSpittles(startvalue, endvalue));
		return "Spittles";

	}

	@RequestMapping(value = "/Register")
	public String register(Model model) {
		logger.info("In register method");
		User usr = new User();
		usr.setUsername("manoj");
		model.addAttribute("User", usr);
		return "Register";
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login(@Valid User user, Errors errors, Model model) {
		logger.info("In Login method");
		logger.info(user.getFirstname() + "" + user.getSecondname() + " "
				+ user.getUsername() + "" + user.getPassword());
		List<User> usrlst = spittlesRepository.checkuser(user.getUsername(),
				user.getPassword());
		if (errors.hasErrors() || usrlst.isEmpty()) {
			model.addAttribute("User",user);
			//model.addAttribute("Error", errors);
			
			return "/Register";
		} else {
			User usr =(User) usrlst.get(0);
			user.setFirstname(usr.getFirstname());
			user.setSecondname(usr.getSecondname());
			model.addAttribute("UserSpittles",spittlesRepository.getUserSpittles(usr.getUsername()));
			model.addAttribute("User", user);
			return "/Profile";
		}
	}

	@RequestMapping(value = "/CreateUser", method = RequestMethod.POST)
	public String createUser(@Valid User user, Errors errors, Model model) {
		logger.info("In Create user method");
		//model.addAttribute("User", user);
		logger.info(user.getFirstname() + "" + user.getSecondname() + " "
				+ user.getUsername() + "" + user.getPassword());
		boolean status = false;
		/*if(!errors.hasErrors()){
		 status= spittlesRepository.createUser(user);
		}*/
		if (status) {
			model.addAttribute("message",
					"User added successfully. Login Below.");

		}
		return "/Register";

	}

	@RequestMapping(value = "/saveSpittle", method = RequestMethod.POST)
	public String saveSpittles(@Valid Spittles spittle, Errors errors,
			Model model) {
		logger.info("In save method");
		logger.info(spittle.getId() + " " + spittle.getMessage());
		logger.info(errors.toString());
		if (errors.hasErrors()) {
			model.addAttribute("Spittles", spittle);
			model.addAttribute("error", errors);
			return "redirect:/Register";
		} else
			return "redirect:/Spittles";
	}

}
