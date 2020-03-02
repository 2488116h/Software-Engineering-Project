package User;
import java.io.PrintStream;
import java.util.ArrayList;


public class ListOfAccount {
	private ArrayList<Account> users;

	public ListOfAccount() {
		users = new ArrayList<Account>();
	}
	
	// add user account to list
	public void addUser(Account user) {
		users.add(user);
	}
	
	// remover user account from list
	public void removeUser(Account user) {
		users.remove(user);
	}
	
	// get the size of the list
	public int getSize() {
		return users.size();
	}
	
	// get the list
	public ArrayList<Account> getUsers() {
		return users;
	}

	// get the user account according to the index
	public Account getUser(int index) {
		return users.get(index);		
	}
		
	// print all user accounts
	public void print(PrintStream ps) {
		for(Account u:users) {
			u.print(ps);
		}
	}
}
