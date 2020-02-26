package Community;

import java.io.PrintStream;

import User.*;

public class Administrator extends User {
	public Administrator(String u, String p, String n, Date d, String NIN) {
		super(u, p, n, d, NIN);
	}
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print("Administrator");
	}

}
