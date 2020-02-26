package Community;

import java.io.PrintStream;
import User.*;

public class Teacher extends User {

	private ListOfAttribute attributes;

	public Teacher(String u, String p, String n, Date d, String NIN, ListOfAttribute attributes) {
		super(u, p, n, d, NIN);
		this.attributes = attributes;
	}

	public ListOfAttribute getAttributes() {
		return attributes;
	}

	public void print(PrintStream ps) {
		super.print(ps);
	}
	
}
