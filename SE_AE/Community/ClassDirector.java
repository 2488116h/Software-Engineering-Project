// package name:
package Community;

import java.io.PrintStream;
import User.Date;
import User.Account;

public class ClassDirector extends Account{
	
	// constructor
	public ClassDirector(String u, String p) {
		super(u, p);
	}

	// print user's role
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" (Class Director)");
	}

	
	/* create a new teacher: with default username and password, and attribute 
	* and add a teacher in the list
	*/
	public void createTeacher(String n, Date d, String g, String NIN,ListOfTeacher ListOfTRs) {
		Teacher tr = new Teacher(n, d, g, NIN);
		ListOfTRs.addTeacher(tr);
	}
	
	
	// create a new class request and add it to the list of Request
	public void createCR(String reqTitle, String reqDetail, ListOfClassReq ListOfCRs) {
		ClassRequest classReq = new ClassRequest(reqTitle, reqDetail);
		ListOfCRs.add(classReq);
	}
	
	// print a list of all class requirement (new and old)
	public void printListOfCR(PrintStream ps, ListOfClassReq ListOfCRs) {
			ps.print(ListOfCRs.toString());
			ps.print("New added:" + "\n");
	//		ps.print(newRequests.toString());
	}
	
}
