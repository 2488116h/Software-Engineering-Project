package User;

import java.io.PrintStream;


public class Account {
	private String username;
	private String password;

	public Account(String u, String p) {
		username = u;
		password = p;
	
	}
	
	public void print(PrintStream ps) {
		ps.print(String.format("Hi, "+username));
	}
	
	public String getPassword() {
		return password;
	}	

	
	public String getUsername() {
		return username;
	}
	
	// setter: account name
	public void setUsername(String u) {
		username = u;
	}
	// setter: account password
	public void setPassword(String p) {
		password = p;
	}

}
