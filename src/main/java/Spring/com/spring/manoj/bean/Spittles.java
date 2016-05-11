package Spring.com.spring.manoj.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spittles {
	@NotNull(message = "Id Cannot be null")
	private int id;
	@NotNull(message = "Message cannot be null")
	@Size(min = 10, message = "Value less than 5")
	private String message;
	private int userid;
	private Date entrydate;
	
	public Spittles() {

	}

	public Spittles(int id, String message, Date date, int userid) {
		this.id = id;
		this.message = message;
		this.entrydate = date;
		this.userid = userid;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

}
