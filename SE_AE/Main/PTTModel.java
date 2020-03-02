package Main;

import Community.*;
import User.*;

public class PTTModel {
	private ClassDirector classDir;
	private PTTDirector PTTDir;
	private Administrator admin;
	private ListOfAccount userAccounts;
	private ListOfClassReq classRequests;
	private ListOfTeacher teachers;
	private ListOfTeacher suitTeachers;

	public PTTModel() {
		userAccounts = new ListOfAccount();
		classRequests = new ListOfClassReq();
		teachers = new ListOfTeacher();
		suitTeachers = new ListOfTeacher();
		
	}

	// according to the username and password , method return the results of login (
	// return the user's role or failed to login)
	public int login(String username, String password) {
		int isLogin = 0;// mark login failed
		for (int i = 0; i < userAccounts.getSize(); i++) {
			if (username.equals(userAccounts.getUser(i).getUsername())
					&& password.equals(userAccounts.getUser(i).getPassword())) {
				if (userAccounts.getUser(i) instanceof ClassDirector) { // Class director login
					classDir = (ClassDirector) userAccounts.getUser(i);
					isLogin = 1;
				} else if (userAccounts.getUser(i) instanceof PTTDirector) { // PTT director login
					PTTDir = (PTTDirector) userAccounts.getUser(i);
					isLogin = 2;
				} else if (userAccounts.getUser(i) instanceof Administrator) { // Administrator login
					admin = (Administrator) userAccounts.getUser(i);
					isLogin = 3;
				}
			}
		}
		return isLogin;
	}

	// Class Director: create class request and add the request to the request list
	public void creatRequest(String reqTitle, String reqDetail) {
		classDir.createCR(reqTitle, reqDetail, classRequests);
	}

	// Class Director: registration for a teacher
	public void registerTeacher(String name, int day, int month, int year, String gender, String NIN) {
		Date dob = new Date(day, month, year);
		classDir.createTeacher(name, dob, gender, NIN, teachers);
	}

	// Administrator: find suitable teacher
	public boolean createSuitTeacher(Teacher teacher) {
		return admin.createSuitTeacher(suitTeachers, teacher);

	}

	// PTT director: check all the submitted class requests and make approval
	public void approval(int choice) {
		if (choice == 1) {
			for (ClassRequest classReq : classRequests.submittedList())
				PTTDir.approve(classReq);
			PTTDir.approve(suitTeachers);

		} else if (choice == 2) {
			for (ClassRequest classReq : classRequests.submittedList())
				PTTDir.diapprove(classReq);
			PTTDir.diapprove(suitTeachers);
		}
	}

	/*
	 * data could be imported from a database: 
	 * 1. list of users 
	 * 2. list of teachers
	 * 3. list of class requests
	 */

	public String accountData() {
		String str = "username,password,userType\n";
		for (Account a : userAccounts.getUsers()) {
			str += String.format("%s,%s,%s\n", a.getUsername(), a.getPassword(), a.getClass().toString());
		}
		return str;
	}

	public String classReqData() {
		String str = "*reqNo,reqTitle,reqDetail,status\n";
		for (ClassRequest cr : classRequests.getListOfCR()) {
			str += String.format("%s,%s,%s,%s\n", cr.getReqNo(), cr.getReqTitle(), cr.getReqDetail(),
					cr.getReqStatus());
		}
		return str;
	}

	public String teacherData(ListOfTeacher list) {
		String str = "*name,gender,nin,birth_day,birth_month,birth_year,status\n";
		for (Teacher t : list.getTeachers()) {
			str += String.format("%s,%s,%s,%d,%d,%d,%s\n", t.getName(), t.getGender(), t.getNIN(), t.getDate().getDay(),
					t.getDate().getMonth(), t.getDate().getYear(), t.getStatus());
		}
		return str;
	}

	// initialize user account
	public void createUser(String username, String password, String role) {

		if (role.contains("ClassDirector")) {
			classDir = new ClassDirector(username, password);
			userAccounts.addUser(classDir);

		} else if (role.contains("PTTDirector")) {
			PTTDir = new PTTDirector(username, password);
			userAccounts.addUser(PTTDir);

		} else if (role.contains("Administrator")) {
			admin = new Administrator(username, password);
			userAccounts.addUser(admin);
		}

	}

	public ClassDirector getClassDir() {
		return classDir;
	}

	public PTTDirector getPTTDir() {
		return PTTDir;
	}

	public Administrator getAdmin() {
		return admin;
	}

	//Accessors
	public ListOfTeacher getTeachers() {
		return teachers;
	}

	public ListOfTeacher getSuitTeachers() {
		return suitTeachers;
	}

	public ListOfClassReq getClassRequests() {
		return classRequests;
	}

}
