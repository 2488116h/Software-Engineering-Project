package Community;

import java.io.PrintStream;

import User.Date;
import User.Account;

public class PTTDirector extends Account{
	
	
	public PTTDirector(String u, String p) {
		super(u, p);
	}
	 
	// approve class request or training request 
	public void approve(Object obj) {
		if(obj instanceof ClassRequest) {// approve class request by set the status to 'Approved'		
			((ClassRequest) obj).setReqStatus(ClassRequest.status[1]);
		}
		if(obj instanceof ListOfTeacher) {// approve training request by add training information
			ListOfTeacher trainingReq=(ListOfTeacher)obj;
			for(Teacher teacher:trainingReq.getTeachers()) {
				teacher.addTraining("attended 2020 term training");
			}
			trainingReq.removeTeacher(null, 1);// clear all teachers in the training request list after approval
		}			
		
	}
	
	// disapprove class request or training request 
	public void diapprove(Object obj) {
		if(obj instanceof ClassRequest) {// disapprove class request by set the status to 'Disapproved'		
			((ClassRequest) obj).setReqStatus(ClassRequest.status[2]);
		}
		// disapprove training request by clearing all teachers in the training request list 
		if(obj instanceof ListOfTeacher) {
			ListOfTeacher trainingReq=(ListOfTeacher)obj;		
			trainingReq.removeTeacher(null, 1);
		}
	}
	
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" PPT Director");
	}

}
