package Main;

import java.util.Scanner;

public class PTTController {
	private PTTModel model;
	private PTTView view;
	private Scanner input;


	public PTTController(PTTModel model, PTTView view) {
		this.model = model;
		this.view = view;
	
	}

	public void login() {
		input = new Scanner(System.in);
		view.enterUsername();
		String username = input.nextLine();
		view.enterPassword();
		String password = input.nextLine();

		int role = model.login(username, password);
		if (role == 0) {
			view.loginFailed();
			this.login();

		} else {
			mainMenu(role);
		}
		;

	}

	public void mainMenu(int role) {// role 1 : Class director, role 2 : PTT director, role 3 : Administrator
		input = new Scanner(System.in);
		view.menu(role);
		int menuNo = input.nextInt();

		if (menuNo == 1) {// 1. choose list all class requests.
			view.listRequests();
			mainMenu(role);
		} else if (menuNo == 2) {// 2. choose to show the list of teacher
			view.listOfTeacher();
			view.listOfSuitTeacher();
			mainMenu(role);
		} else if (menuNo == 3) {
			if(role == 1) { // 3. choose create class request.
				if (!createReq()) {
					mainMenu(role);
				};

			} else if (role == 2) {// 3. choose list all submitted requests.
				if (model.getRequests().submittedList().size() == 0) {
					view.noRequest();
					mainMenu(role);
				}
				view.approval_menu();
				model.approval(input.nextInt());
				
				mainMenu(role);

			} else if (role == 3) {// 3. choose to create a list of suitable teacher.
				view.listOfTeacher();
				view.createSuitTeacher();
				input = new Scanner(System.in);
				int index = input.nextInt();

				while(index!=0) {
					model.createSuitTeacher(model.getTeachers().getTeacher(index-1));
					view.addedTeacher();
					index = input.nextInt();
				}
				mainMenu(role);
			}
		}else if (menuNo == 4) {// 4. choose logout
			view.logout();
			this.login();
		}
	}

	/*Class Director responsibilities-1:
	 	* 1. create a class request
	 	* 2. 
	 	*/
	public boolean createReq() {
		boolean flag = true;
		input = new Scanner(System.in);
		view.createReqTitle();
		String title = input.next();
		view.createReqDetails();
		String detail = input.next();
		model.creatRequest(title, detail);
		view.submitteReq();
		

		if (input.nextInt() == 1) {
			this.createReq();
		} else {
			flag = false;
		}

		return flag;
	}

	/*Class Director responsibilities-2: 
	 	* 1. find this teacher or
	 	* 2. register this teacher into the suitable list
	 	*/
	public void registerTR() {
		view.createSuitTeacher();
		input = new Scanner(System.in);
		String teacherNIN = input.next();
		
		if(model.getTRs().check(teacherNIN)) {
			view.teacherExists(teacherNIN);
		}else {
			view.createTeacherGuide();
			input = new Scanner(System.in);
			String teacherName = input.next();
			int day = input.nextInt();
			int month = input.nextInt();
			int year = input.nextInt();
			String gender = input.nextLine();
			model.registerTeacher(teacherName, day, month, year, gender, teacherNIN);
			view.addedTeacher();
		}
	}
	
}
