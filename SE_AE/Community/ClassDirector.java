package Community;

import java.io.PrintStream;

//import java.util.Scanner;

import User.Date;
import User.User;

public class ClassDirector extends User{
	public ClassDirector(String u, String p, String n, Date d, String NIN) {
		super(u, p, n, d, NIN);
		// TODO Auto-generated constructor stub

	}
	
//	public void creatClassReq() {
//		System.out.println("Please enter the Title: ");
//		Scanner s = new Scanner(System.in);
//		String title = s.nextLine();
//		System.out.println("Please enter the Description: ");
//		String details = s.nextLine();		
//		new ClassRequest(title,details);
//		
//	}
	
	public ClassRequest createClassReq(String reqTitle,String reqDetail) {
		return new ClassRequest(reqTitle,reqDetail,ClassRequest.status[0]);
	}
	
	public Teacher createTeacher( String name, Date date, String nIN) {
		return new Teacher(null,null,name,date,nIN,null);
	}
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" Class Director");
	}

}
