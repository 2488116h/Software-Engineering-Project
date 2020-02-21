package User;

import java.io.PrintStream;

public class User {
	private String username;
	private char[] password;
	private String name;	
	private Date date;
	private String NIN;
	private boolean flag;
	public User(String u, char[] p, String n, Date d, String NIN) {
		username = u;
		password = p;
		name = n;
		date = d;
		this.NIN = NIN;
	}
	
	public void print(PrintStream ps) {
		ps.print(String.format("Hi, "+name));
	}
	
	public char[] getPassword() {
		return password;
	}	
	
	public String getName() {
		return name;
	}
	
	

}
