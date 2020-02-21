package User;
import java.io.PrintStream;
import java.util.ArrayList;


public class ListOfUser {
	private ArrayList<User> users;
	private User u;
	public ListOfUser() {
		users = new ArrayList<User>();
	}
	
	public void print(PrintStream ps) {
		for(User u:users) {
			u.print(ps);
		}
	}
}
