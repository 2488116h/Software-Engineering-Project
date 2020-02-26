// package name: Account_Type
// User: Person
package Community;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import User.Date;
import User.User;

public class ClassDirector extends User{
	
	private ListOfClassReq newRequests;
	// constructor
	public ClassDirector(String u, String p, String n, Date d, String NIN) {
		super(u, p, n, d, NIN);
	}

//	public void creatClassReq() {
//		System.out.println("Please enter the Title: ");
//		Scanner s = new Scanner(System.in);
//		String title = s.nextLine();
//		System.out.println("Please enter the Description: ");
//		String details = s.nextLine();		
//		new ClassRequest(title,details);
//	}
	
	// super ??
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" Class Director");
	}

	// find this teacher 
	public boolean find(String teacherName, ListOfTeacher ListOfTRs) {
		return ListOfTRs.check(teacherName);
	}
	
	// create a new teacher: with default username and password, and attribute
	public Teacher createTeacher(String n, Date d, String NIN) {
		String defaultUserName = n;
		String defaultPassword = Integer.toString(d.getDay()) + Integer.toString(d.getMonth()) + Integer.toString(d.getYear());
		ListOfAttribute attributes = new ListOfAttribute();
		Teacher tr = new Teacher(defaultUserName, defaultPassword, n, d, NIN, attributes);
		return tr;
	}
	
	// add a teacher in the list
	public void addTeacher(Teacher tr, ListOfTeacher ListOfTRs) {
		ListOfTRs.addTeacher(tr);
	}
	
	// create a new class request and add it to the list of Request
	public void createCR(String reqTitle, String reqDetail) {
		ClassRequest classReq = new ClassRequest(reqTitle, reqDetail);
		newRequests.add(classReq);
	}
	
	// print a list of all class requirement (new and old)
	public void printListOfCR(PrintStream ps, ListOfClassReq ListOfCRs) {
			ps.print(ListOfCRs.toString());
			ps.print("New added:" + "\n");
			ps.print(newRequests.toString());
	}
	
}
