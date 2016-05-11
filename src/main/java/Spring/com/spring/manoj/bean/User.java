package Spring.com.spring.manoj.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class User implements Validator  {
	@NotNull(message = "Please enter a firstname")
	@Size(min =1 , message ="Enter firstname")
	private String firstname;
	@NotNull(message = "Please enter a secondname")
	private String secondname;
	@NotNull(message = "Please enter a username")
	private String username;
	@NotNull(message = "Please enter a password")
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {

	}

	public User(String firstname, String secondname, String username,
			String password) {
		this.firstname = firstname;
		this.secondname = secondname;
		this.username = username;
		this.password = password;

	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}
}
