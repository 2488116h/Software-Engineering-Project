package Main;

/*
 * data could be imported from a database:
 * 1. list of users
 * 2. list of teachers
 * 3. list of class requests
 */
import Community.*;
import User.*;

public class PTTModel {
	private ClassDirector classDir;
	private PTTDirector PTTDir;
	private Administrator admin;
	private ListOfAccount userAccounts =new ListOfAccount();
	private ListOfClassReq classRequests=new ListOfClassReq();		
	private ListOfTeacher teachers =new ListOfTeacher();
	private ListOfTeacher  suitTeachers=new ListOfTeacher();


	public PTTModel() {
		classDir=new ClassDirector("user01","1");
		PTTDir=new PTTDirector("user02","1");
		admin=new Administrator("user03","1");

		userAccounts.addUser(classDir);
		userAccounts.addUser(PTTDir);
		userAccounts.addUser(admin);

	}
	// according to the username and password , method return the results of login ( return the user's role or failed to login) 
	public int login(String username,String password) {
		int isLogin=0;// mark login failed
		for(int i =0;i<userAccounts.getSize();i++) {
			if(username.equals(userAccounts.getUser(i).getUsername())&& password.equals(userAccounts.getUser(i).getPassword())) {
				if(userAccounts.getUser(i) instanceof ClassDirector) {  // Class director login
					isLogin=1;
				}else if(userAccounts.getUser(i) instanceof PTTDirector) {  // PTT director login
					isLogin=2;
				}
				else if(userAccounts.getUser(i) instanceof Administrator) {  // Administrator login
					isLogin=3;
				}
			}
		}
		return isLogin;
	}
	
	// Class Director: create class request and add the request to the request list
	public void creatRequest(String reqTitle,String reqDetail) {	
		classDir.createCR(reqTitle,reqDetail,classRequests);
	}
	
		
	// Class Director: registration for a teacher
	public void registerTeacher(String name, int day, int month, int year, String gender, String NIN) {
		Date dob = new Date(day,month,year);
		classDir.createTeacher(name, dob, gender,NIN,teachers);
	}
	
	// Administrator: find suitable teacher	
	public void createSuitTeacher(Teacher teacher) {
		admin.createSuitTeacher(suitTeachers, teacher);
		
	}
	
	// PTT director: check the list of suitable teacher who needs to take training and make approval 
//	public void trainingApproval(int choice) {		
//		if(choice==1) {
//				PTTDir.approve(suitTeachers);
//
//		}else if(choice==2) {
//				PTTDir.diapprove(suitTeachers);
//		}				
//	}

	// PTT director: check all the submitted class requests and make approval
	public void approval(int choice) {
		if(choice==1) {
			for(ClassRequest classReq:classRequests.submittedList()) 
				PTTDir.approve(classReq);
			PTTDir.approve(suitTeachers);
			

		}else if(choice==2) {
			for(ClassRequest classReq:classRequests.submittedList()) 
				PTTDir.diapprove(classReq);
			PTTDir.diapprove(suitTeachers);
		}
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


	public String classReqData() {
		String str="";
		for(ClassRequest cr:classRequests.getListOfCR()) {
			str+=cr.getReqTitle()+","+cr.getReqDetail()+","+cr.getReqStatus()+"\n";
		}
		return str;
	}
	
	public String teacherData() {
		String str="";
		for(Teacher t:teachers.getTeachers()) {
			str+=t.toString()+"\n";
		}
		return str;
	}
	
	
}
