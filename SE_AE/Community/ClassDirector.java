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

	// super
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" Class Director");
	}

	// find this teacher 
	public boolean find(String teacherNIN, ListOfTeacher ListOfTRs) {
		return ListOfTRs.check(teacherNIN);
	}
	
	// create a new teacher: with default username and password, and attribute
	public Teacher createTeacher(String n, Date d, String g, String NIN) {
		Teacher tr = new Teacher(n, d, g, NIN);
		return tr;
	}
	
	// add a teacher in the list
	public void addTeacher(Teacher tr, ListOfTeacher ListOfTRs) {
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
	}
	
}
