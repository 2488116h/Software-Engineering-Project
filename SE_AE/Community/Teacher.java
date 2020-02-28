package Community;

import User.*;

public class Teacher extends Person {

	private String status;

	public Teacher( String n, Date d,String g, String NIN, String status) {
		super(n, d, g, NIN);
		this.status=status;
	}
	
	
	
}
