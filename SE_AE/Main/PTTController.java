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
		};

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
			view.createTeacherMenu();
			
			if(input.nextInt()==1) {
				
				if(!registerTR()) 
					mainMenu(role);
				
			}
		
			
		} else if (menuNo == 3) {
			if(role == 1) { // 3. choose create class request.
				if (!createReq()) {
					mainMenu(role);
				};

			} else if (role == 2) {// 3. choose list all submitted requests.
				view.selectReq();
				int index=input.nextInt();
				if(index==1) {// 1. choose list all submitted class requests.
					if (model.getClassRequests().submittedList().size() == 0) {
						view.noItems();
						mainMenu(role);
					}
					view.submittedList_ClassReq();
					model.approval(input.nextInt());
			//		data.classReqData();
			//		data.writeFile();
				}else if(index==2) {// 2. choose list all submitted training requests.
					view.submittedList_TrainReq();
					int select=input.nextInt();
					if(select==1||select==2) {// 1. approve 2.disapprove 3. return Main Menu
						model.trainingApproval(select);
						view.approval_result(select);
					}
									
				}
					mainMenu(role);
				
			

			} else if (role == 3) {// 3. choose to create a list of suitable teacher.
				view.listOfTeacher();
				view.addSuitTeacher();
				int index = input.nextInt();
				
				while(index!=0) {// 
					model.createSuitTeacher(model.getTeachers().getTeacher(index-1));
					view.addNewSuitTeacher();
					index = input.nextInt();
			//		data.trainingReqData();
			//		data.writeFile();
				}
				mainMenu(role);
			}
		}else if (menuNo == 4) {// 4. choose logout
			view.logout();
			this.login();
		}
	}

	// create class request method, when it returns true, it will create next class request
	/*Class Director responsibilities-1:
	 	* 1. create a new class request
	 	* 2. add this CR in the list
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
//		data.classReqData();
//		data.writeFile();

		if (input.nextInt() == 1) {// chose 1 means that create a new class request
			this.createReq();
		} else {
			flag = false;
		}
		
		return flag;
	}

	/*Class Director responsibilities-2: 
	 	* 1. find a teacher or
	 	* 2. register this new teacher into the suitable list
	 	*/
	public boolean registerTR() {
		boolean flag= true;
		// prompt for entering NIN
		view.createTeacher();
		view.createNIN();
		// User input: 
		input = new Scanner(System.in);
		String teacherNIN = input.next();
		
		// try to find matched teacher
		if(model.getTeachers().containNIN(teacherNIN)) {
			view.teacherExists(teacherNIN);
			registerTR();
			
		}else {
			// Name 
			view.createName();		
			input = new Scanner(System.in);
			String teacherName = input.nextLine();
			// Date of birth
			view.createBirthDate();
		
			int day = input.nextInt();
			int month = input.nextInt();
			int year = input.nextInt();
				// Gender
			view.createGender();
		
			int index = input.nextInt()-1;
			String[] gender= {"male","female"};
			model.registerTeacher(teacherName, day, month, year, gender[index], teacherNIN);
			view.createTeacherMenu();
			
			if(input.nextInt()==1) {
				registerTR();
			}else flag=false;
		}
		return flag;
	}
	
}
