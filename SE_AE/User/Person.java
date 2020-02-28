package User;

public class Person {
	
	private String name;
	private Date d;
	private String gender;
	// NIN = National Insurance Number (UK)
	private String NIN;
	
	public Person(String name, Date d, String gender, String NIN) {
		this.name = name;
		this.d = d;
		this.gender = gender;
		this.NIN = NIN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
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
	
}
