package Main;



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
	private ListOfClassReq classRequests=new ListOfClassReq();	
	private Administrator admin;
	private ListOfTeacher teachers =new ListOfTeacher();
	private ListOfTeacher  suitTeachers=new ListOfTeacher();
	private ListOfTeacher  approvedTrainingReq=new ListOfTeacher();
	private Teacher teacher1,teacher2;
//	private suitTeacherForm form;

	
	public PTTModel() {
		classDir=new ClassDirector("user01","1","Jam",new Date(01,01,1999),"S123456");
		PTTDir=new PTTDirector("user02","1","Tommy",new Date(01,04,1989),"S123488");
		admin=new Administrator("user03","1","Ted",new Date(01,01,1990),"S132987");
		teacher1=new Teacher(null,null,"Mony",new Date(01,01,1990),"S132986",null);
		teacher2=new Teacher(null,null,"Nemo",new Date(01,01,1990),"S132986",null);
		
//		classDir.createTeacher("Mony",new Date(01,01,1990),"S132986");
//		classDir.createTeacher("Nemo",new Date(01,01,1990),"S132986");
		users.addUser(classDir);
		users.addUser(PTTDir);
		users.addUser(admin);
		teachers.addTeacher(teacher1);
		teachers.addTeacher(teacher2);
		
	}
	// according to the username and password , method return the results of login ( return the user's role or failed to login) 
	public int login(String username,String password) {
		int isLogin=0;// mark login failed
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
	
	// create class request and add the request to the request list
	public void creatRequest(String reqTitle,String reqDetail) {	
		classRequests.add(classDir.createClassReq(reqTitle,reqDetail));
	}
	
	
	
	public void createTeacher(String name, Date date, String nIN) {
		teachers.addTeacher(classDir.createTeacher(name, date, nIN));
	}
	
	// PTT director: check the list of suitable teacher who needs to take training and make approval 
	public void trainingApproval(int choice) {		
		if(choice==1) {
				PTTDir.approve(suitTeachers);

		}else if(choice==2) {
				PTTDir.diapprove(suitTeachers);
		}				
	}
	
	// PTT director: check all the submitted class requests and make approval 
	public void approval(int choice) {
		if(choice==1) {
			for(ClassRequest classReq:classRequests.submittedList()) 
				PTTDir.approve(classReq);

		}else if(choice==2) {
			for(ClassRequest classReq:classRequests.submittedList()) 
				PTTDir.diapprove(classReq);
		}
	}
	
	
	
	
	// Administrator: find suitable teacher	
	public void createSuitTeacher(Teacher teacher) {
		admin.createSuitTeacher(suitTeachers, teacher);
		
	}

	public ListOfTeacher getTeachers() {
		return teachers;
	}

	public ListOfTeacher getSuitTeachers() {
		return suitTeachers;
	}
	public void setClassRequests(Object obj) {
		ListOfClassReq classRequests =(ListOfClassReq)obj;
		this.classRequests = classRequests;
	}
	public ListOfClassReq getClassRequests() {
		return classRequests;
	}
	public void setTeachers(Object obj) {
		ListOfTeacher teachers=(ListOfTeacher)obj;
		this.teachers = teachers;
	}
	public void setSuitTeachers(Object obj) {
		ListOfTeacher suitTeachers = (ListOfTeacher)obj;
		this.suitTeachers = suitTeachers;
	}
	public ListOfUser getUsers() {
		return users;
	}
	
	

	public String classReqData() {
		String str="";
		for(ClassRequest cr:classRequests.getListOfCR()) {
			str+=cr.getReqTitle()+","+cr.getReqDetail()+","+cr.getReqStatus()+"\n";
		}
		return str;
	}
	
	



}
