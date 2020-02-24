package Main;

import Community.ClassDirector;
import Community.PTTDirector;
import User.Date;
import User.ListOfUser;

public class PTTModel {
	private ClassDirector classDir;
	private PTTDirector PTTDir;
	private ListOfUser users;
	
	public PTTModel() {
		classDir=new ClassDirector("use01","123456","Jam",new Date(01,01,1999),"S123456");
		PTTDir=new PTTDirector("use02","123456","Tommy",new Date(01,04,1989),"S123488");
		users.addUser(classDir);
		users.addUser(PTTDir);
	}
	
	public boolean login(String username,String password) {
		boolean isLogin=false;
		for(int i =0;i<users.getSize();i++) {
			if(username.equals(users.getUser(i).getUsername())&& password.equals(users.getUser(i).getPassword())) {
				isLogin=true;
			}
		}
		
		return isLogin;

	}
	
	
	public void creatRequest() {
		
	}


}
