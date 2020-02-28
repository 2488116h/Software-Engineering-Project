package Community;

import java.io.PrintStream;

import User.*;
public class Teacher extends User {
	
	private ListOfAttribute attributes; 
	
	public Teacher(String username, String password, String name, Date date, String nIN,ListOfAttribute attributes) {
		super(username, password, name, date, nIN);
		this.attributes = attributes;
		this.attributes=new ListOfAttribute();
	}
	
	public ListOfAttribute getAttributes() {
		return attributes;
	}
	
	
	
	public void addTraining(String training) {
		this.attributes.addAttribute(training);
	}
	
	public Teacher clone() {
		return this.clone();
	}
	

	public void print(PrintStream ps) {
		ps.print(this.getName()+ " ");
		attributes.print(ps);
		
	}

}
