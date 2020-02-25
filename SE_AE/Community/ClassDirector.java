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
	
	private ListOfTeacher ListOfTRs;
	private ListOfClassReq ListOfCR;
	
	// constructor
	public ClassDirector(String u, String p, String n, Date d, String NIN) {
		super(u, p, n, d, NIN);
		// import data from database
		//ListOfTRs = ;
		//ListOfCR = ;
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
	public boolean find(String teacherName) {
		return ListOfTRs.check(teacherName);
	}
	
	// create a new teacher
	public Teacher createTeacher(String u, String p, String n, Date d, String NIN) {
		Teacher tr = new Teacher(u, p, n, d, NIN);
		return tr;
	}
	
	// add a teacher in the list
	public void createTeacher(Teacher tr) {
		ListOfTRs.add(tr);
	}
	
	// check and register a teacher
//	public void register(String teacherName) {
//		if(ListOfTRs.check(teacherName)) {
//			System.out.println(t.getName() + "is already in the List.");
//		}else {
//			createTeacher()
//			System.out.println(t.getName() + "is successfully added.");
//		}
//	}
	
	// create a new class request and add it to the list of Request
	public void createCR(String reqTitle,String reqDetail) {
		ClassRequest classReq = new ClassRequest(reqTitle, reqDetail);
		ListOfCR.add(classReq);
	}
	
	// print list of class requirement
	public void printListOfCR(PrintStream ps) {
			ps.print(ListOfCR.toString());
	}
	
}
