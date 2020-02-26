package User;

import java.io.PrintStream;


public class User {
	private String username;
	private String password;
	private String name;	
	private Date date;
	// NIN = National Insurance Number (UK)
	private String NIN;
	private boolean flag;
	
	public User(String u, String p, String n, Date d, String NIN) {
		username = u;
		password = p;
		name = n;
		date = d;
		this.NIN = NIN;
	}
	
	public void print(PrintStream ps) {
		ps.println(String.format("Hi, "+name));
	}
	
	public String getPassword() {
		return password;
	}	
	
	public String getName() {
		return name;
	}
	
	public String getUsername() {
		return username;
	}

}
