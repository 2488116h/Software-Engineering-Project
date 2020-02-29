package User;
import java.io.PrintStream;
import java.util.ArrayList;


public class ListOfAccount {
	private ArrayList<Account> users;

	public ListOfAccount() {
		users = new ArrayList<Account>();
	}
	
	public void addUser(Account user) {
		users.add(user);
	}
	
	public void removeUser(Account user) {
		users.remove(user);
	}
	
	public int getSize() {
		return users.size();
	}
	
	public Account getUser(int index) {
		return users.get(index);		
	}
		
	public void print(PrintStream ps) {
		for(Account u:users) {
			u.print(ps);
		}
	}
}
