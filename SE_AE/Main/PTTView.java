package Main;

import java.util.HashMap;
import java.util.Scanner;

public class PTTView {
	
	private PTTModel model;
	
	public PTTView(PTTModel model) {
		this.model=model;
		model = new PTTModel();
	}
	
	public HashMap<String,String> login() {
//		String[] user=new String[2];
		HashMap<String,String> user= new HashMap<>();
		System.out.println("-------Login------\n Please Enter Your Username:");
		Scanner s = new Scanner(System.in);
		user.put("username",s.nextLine());
		System.out.println("Please Enter Your Password:");
		user.put("password",s.nextLine());
		
		return user;
		
	}
	
	public void printMenu(int role) {
		if(role==1) {
			System.out.print("1.create new class requirement\n2.list all the class requests\n3.logout\n");
		}
	}

	//System prompt for creating a new Teacher 
	public void createTeacherGuide(String teacherName) {
		System.out.println(teacherName + "is already in the List.");
		
		System.out.println("Please enter the Personal Information of this new Teacher.");
		System.out.println("First, enter his/her date of birth:");
		
		System.out.println("Then, enter his/her National Insurance Number:");
		
		System.out.println("Finally, enter the default Username and defalut Password for his/her User account:");
	}
	
	// collect user input for a new teacher
	public void CDInput(Scanner sc) {
		
	}
	
}
