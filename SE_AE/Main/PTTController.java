package Main;

import java.util.Scanner;

public class PTTController {
	private PTTModel model;
	private PTTView view;
	
	// ??? Separate
	public PTTController(PTTModel model,PTTView view) {
		this.model=model;
		this.view=view;
	}
	
	public void login() {
		if(model.login(view.login().get("username"), view.login().get("password"))) {
			
		};
	}
	
	/*
	 * -----------------------------------------------------
	 * Class Director
	 */
	
	// process of registering a teacher: check, create, add
	public void registerTR(String teacherName) {
		if(model.getTRs().check(teacherName)) {
			System.out.println(teacherName + "is already in the List.");
		}else {
			System.out.println();
			Scanner s = new Scanner(System.in);
			classDir.createTeacher("u", "p", "n", null, "NIN");
			System.out.println(teacherName + "is successfully added.");
		}
	}

}
