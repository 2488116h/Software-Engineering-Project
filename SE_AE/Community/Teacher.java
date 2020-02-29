package Community;

import java.io.PrintStream;

import User.*;

public class Teacher extends Person {

	private String status;

	public Teacher(String n, Date d,String g, String NIN) {
		super(n, d, g, NIN);
		status = "Pending";
	}
	
	// setter for status
	public void setStatus(String status) {
		this.status = status;
	}
	
	// getter for status
	public String getStatus() {
		return status;
	}

	public String toString() {
		
		return super.toString()+","+status;		

	}
	
}
