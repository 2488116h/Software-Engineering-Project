package Main;



import Community.ClassDirector;
import Community.ClassRequest;
import Community.ListOfClassReq;
import Community.PTTDirector;
import User.Date;
import User.ListOfUser;

import Community.Administrator;

public class PTTModel {
	private ClassDirector classDir;
	private PTTDirector PTTDir;	
	private ListOfUser users =new ListOfUser();
	private ListOfClassReq requests=new ListOfClassReq();
	
	private Administrator admin;
//	private ListOfClassReq surequests;
	
	public PTTModel() {
		classDir=new ClassDirector("user01","1","Jam",new Date(01,01,1999),"S123456");
		PTTDir=new PTTDirector("user02","1","Tommy",new Date(01,04,1989),"S123488");
		admin=new Administrator("user03","1","Ted",new Date(01,01,1990),"S132987");
		users.addUser(classDir);
		users.addUser(PTTDir);
		users.addUser(admin);
	}
	
	public int login(String username,String password) {
		int isLogin=0;
		for(int i =0;i<users.getSize();i++) {
			if(username.equals(users.getUser(i).getUsername())&& password.equals(users.getUser(i).getPassword())) {
				if(users.getUser(i) instanceof ClassDirector) {
					isLogin=1;
				}else if(users.getUser(i) instanceof PTTDirector) {
					isLogin=2;
				}
				else if(users.getUser(i) instanceof Administrator) {     // Administrator login
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
	
	public void approval(int choice) {
		if(choice==1) {
			for(int i =0;i<requests.submittedList().size();i++) 
				requests.getClassReq(i).setReqStatus(ClassRequest.status[1]);

		}else if(choice==2) {
			for(int i =0;i<requests.submittedList().size();i++) 
				requests.getClassReq(i).setReqStatus(ClassRequest.status[2]);
		}
	}



}
