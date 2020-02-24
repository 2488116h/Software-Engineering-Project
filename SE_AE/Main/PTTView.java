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

}
