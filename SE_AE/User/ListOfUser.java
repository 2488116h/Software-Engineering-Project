package User;
import java.io.PrintStream;
import java.util.ArrayList;


public class ListOfUser {
	private ArrayList<User> users;
	private User u;
	public ListOfUser() {
		users = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public int getSize() {
		return users.size();
	}
	
	public User getUser(int index) {
		return users.get(index);
		
	}

	
	public void print(PrintStream ps) {
		for(User u:users) {
			u.print(ps);
		}
	}
}
