package Main;

import java.util.Scanner;

public class PTTController {
	private PTTModel model;
	private PTTView view;
	private Scanner input;
	private DataFile data;

	public PTTController(PTTModel model, PTTView view) {
		this.model = model;
		this.view = view;
		data = new DataFile(model);
	}

	public void start() {
		input = new Scanner(System.in);
		view.enterUsername();
		String username = input.nextLine();
		view.enterPassword();
		String password = input.nextLine();

		int role = model.login(username, password);
		if (role == 0) {
			view.loginFailed();
			this.start();

		} else if (role == 1) {
			classDirMenu(role);
		} else if (role == 2) {
			PTTdirMenu(role);
		} else if (role == 3) {
			adminMenu(role);
		}

	}

	public void classDirMenu(int role) {
		view.menu(role);
		input = new Scanner(System.in);
		int menuNo = input.nextInt();

		if (menuNo == 1) {// 1. choose list all class requests.
			view.listRequests();
			classDirMenu(role);

		} else if (menuNo == 2) {// 2. choose to show the list of teacher
			view.listOfTeacher();
			classDirMenu(role);
			;

		} else if (menuNo == 3) {// 3. choose create class request
			createReq();
			classDirMenu(role);

		} else if (menuNo == 4) {// 4. choose create new teacher
			registerTR();
			classDirMenu(role);
		} else if (menuNo == 5) {// 5. choose logout
			view.logout();
			this.start();
		}

	}

	public void adminMenu(int role) {
		view.menu(role);
		input = new Scanner(System.in);
		int menuNo = input.nextInt();

		if (menuNo == 1) {// 1. choose list all class requests.
			view.listRequests();
			adminMenu(role);

		} else if (menuNo == 2) {// 2. choose to show the list of teacher
			view.listOfTeacher();
			adminMenu(role);

		} else if (menuNo == 3) {// 3. find suitable teacher
			view.listOfTeacher();
			view.listOfSuitTeacher();
			view.addSuitTeacher();
			int index = input.nextInt();

			while (index != 0) {// check whether added teacher is already in the list
				if(!model.createSuitTeacher(model.getTeachers().getTeacher(index - 1))) {
					view.failToAdd();
				};
				view.addNewSuitTeacher();
				index = input.nextInt();

				data.writeFile();
			}
			adminMenu(role);

		} else if (menuNo == 4) {// 4. check suitable teacher list
			view.listOfSuitTeacher();
			adminMenu(role);
		}else if(menuNo == 5){// 5. choose create new teacher
			registerTR();
			adminMenu(role);
		} else if (menuNo == 6) {// 6. choose logout
			view.logout();
			this.start();
		}
	}

	public void PTTdirMenu(int role) {
		view.menu(role);
		input = new Scanner(System.in);
		int menuNo = input.nextInt();

		if (menuNo == 1) {// 1. choose list all class requests.
			view.listRequests();
			PTTdirMenu(role);

		} else if (menuNo == 2) {// 2. choose to show the list of teacher
			view.listOfTeacher();
			PTTdirMenu(role);

		} else if (menuNo == 3) {// 3. approve/disapprove requests
			// view.selectReq();
			if (model.getClassRequests().submittedList().size() == 0) {
				view.noItems();
				PTTdirMenu(role);
			}
			view.submittedList_ClassReq();
			view.listOfSuitTeacher();
			view.approval_menu();

			model.approval(input.nextInt());
			// data.classReqData();
			data.writeFile();

			PTTdirMenu(role);

		} else if (menuNo == 4) {// 4. choose logout
			view.listOfSuitTeacher();
			PTTdirMenu(role);
		} else if (menuNo == 5) {// 5. choose logout
			view.logout();
			this.start();
		}
	}

	/*
	 * Class Director responsibilities-1: 1. create a new class request 2. add this
	 * CR in the list
	 */
	public void createReq() {
		input = new Scanner(System.in);
		view.createReqTitle();
		String title = input.nextLine();
		view.createReqDetails();
		String detail = input.nextLine();
		model.creatRequest(title, detail);
		view.submitteReq();

		data.writeFile();

	}

	/*
	 * Class Director responsibilities-2: 1. find a teacher or 2. register this new
	 * teacher into the suitable list
	 */
	public void registerTR() {
		// prompt for entering NIN
		view.createTeacher();
		view.createNIN();
		// User input:
		input = new Scanner(System.in);
		String teacherNIN = input.next();

		// try to find matched teacher
		if (model.getTeachers().containNIN(teacherNIN)) {
			view.teacherExists(teacherNIN);
			registerTR();

		} else
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

		int index = input.nextInt() - 1;
		String[] gender = { "male", "female" };
		model.registerTeacher(teacherName, day, month, year, gender[index], teacherNIN);
		data.writeFile();
		view.createFinined();

	}

}
