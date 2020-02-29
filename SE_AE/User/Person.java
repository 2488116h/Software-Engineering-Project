package User;

import java.io.PrintStream;

public class Person {
	
	private String name;
	private Date date;
	private String gender;	
	private String NIN;// NIN = National Insurance Number (UK)
	
	public Person(String name, Date date, String gender, String NIN) {
		this.name = name;
		this.date = date;
		this.gender = gender;
		this.NIN = NIN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date d) {
		this.date = d;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNIN() {
		return NIN;
	}

	public void setNIN(String nIN) {
		NIN = nIN;
	}
	
	public String toString() {
		return String.format("%s,%s,%s,%s",name, gender, NIN, date.toString());
	}
	
}
