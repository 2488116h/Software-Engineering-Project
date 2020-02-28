package Community;

import java.io.PrintStream;

import User.*;

public class Administrator extends Account {
	public Administrator(String u, String p) {
		super(u, p);
	}
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print("Administrator");
	}

}
