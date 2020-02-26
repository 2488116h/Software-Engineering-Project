// package name: Account_Type
// User: Person
package Community;

import java.io.PrintStream;

//import java.util.Scanner;

import User.Date;
import User.User;
// ----------------------------------------
// New
import java.util.List;
import java.util.Scanner;

public class ClassDirector extends User{
	
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
	
	// create a new teacher
	public Teacher createTeacher(String u, String p, String n, Date d, String NIN) {
		Teacher tr = new Teacher(u, p, n, d, NIN);
		return tr;
	}
	
	// add a teacher in the list
	public void addTeacher(Teacher tr, ListOfTeacher ListOfTRs) {
		ListOfTRs.add(tr);
	}
	
	// create a new class request and add it to the list of Request
	public void createCR(String reqTitle, String reqDetail, ListOfClassReq ListOfCRs) {
		ClassRequest classReq = new ClassRequest(reqTitle, reqDetail);
		ListOfCRs.add(classReq);
	}
	
	// print list of class requirement
	public void printListOfCR(PrintStream ps, ListOfClassReq ListOfCRs) {
			ps.print(ListOfCRs.toString());
	}
	
}
