package Main;

/*
 * data that needs to be modified and updated:
 * 1. list of teacher, new teacher
 * 2. list of class requests, new CR
 *
 * data could be imported from a database:
 * 1. list of users
 * 2. list of teachers
 * 3. list of class requests
 */


import Community.ClassDirector;
import Community.ClassRequest;
import Community.ListOfClassReq;
import Community.ListOfTeacher;
import Community.PTTDirector;
import Community.Teacher;
import User.Date;
import User.ListOfUser;

import Community.Administrator;

public class PTTModel {
	private ClassDirector classDir;
	private PTTDirector PTTDir;
	private ListOfUser users =new ListOfUser();
	private ListOfClassReq requests=new ListOfClassReq();
	private Administrator admin;
	private ListOfTeacher teachers =new ListOfTeacher();
	private ListOfTeacher  suitTeachers=new ListOfTeacher();
	private Teacher teacher1,teacher2;


	public PTTModel() {
		classDir=new ClassDirector("user01","1","Jam",new Date(01,01,1999),"S123456");
		PTTDir=new PTTDirector("user02","1","Tommy",new Date(01,04,1989),"S123488");
		admin=new Administrator("user03","1","Ted",new Date(01,01,1990),"S132987");
		teacher1=new Teacher(null,null,"Mony",new Date(01,01,1990),"S132986",null);
		teacher2=new Teacher(null,null,"Nemo",new Date(01,01,1990),"S132986",null);
		users.addUser(classDir);
		users.addUser(PTTDir);
		users.addUser(admin);
		teachers.addTeacher(teacher1);
		teachers.addTeacher(teacher2);

	}

	public int login(String username,String password) {
		int isLogin=0;
		for(int i =0;i<users.getSize();i++) {
			if(username.equals(users.getUser(i).getUsername())&& password.equals(users.getUser(i).getPassword())) {
				if(users.getUser(i) instanceof ClassDirector) {  // Class director login
					isLogin=1;
				}else if(users.getUser(i) instanceof PTTDirector) {  // PTT director login
					isLogin=2;
				}
				else if(users.getUser(i) instanceof Administrator) {  // Administrator login
					isLogin=3;
				}
			}
		}
		return isLogin;
	}


	public void creatRequest(String reqTitle,String reqDetail) {
		requests.add(new ClassRequest(reqTitle,reqDetail));
	}

	public ListOfClassReq getRequests() {
		return requests;
	}
	
	// Class Director: registration for a teacher
	public void registerTeacher(int day, int month, int year, String NIN, String name) {
		Date dob = new Date(day,month,year);
		classDir.addTeacher(classDir.createTeacher(name, dob, NIN), teachers);
	}

	// PTT director: check all the submitted class requests and make approval
	public void approval(int choice) {
		if(choice==1) {
			for(int i =0;i<requests.submittedList().size();i++)
				requests.getClassReq(i).setReqStatus(ClassRequest.status[1]);

		}else if(choice==2) {
			for(int i =0;i<requests.submittedList().size();i++)
				requests.getClassReq(i).setReqStatus(ClassRequest.status[2]);
		}
	}

	// Administrator: find suitable teacher

	public void createSuitTeacher(Teacher teacher) {
		suitTeachers.addTeacher(teacher);
	}

	public ListOfTeacher getTeachers() {
		return teachers;
	}

	public ListOfTeacher getSuitTeachers() {
		return suitTeachers;
	}



	// getters
	public ListOfTeacher getTRs() {
		return teachers;
	}
	public ListOfClassReq getCRs() {
		return requests;
	}

}
