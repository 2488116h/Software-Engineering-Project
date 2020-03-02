package Community;

import java.io.PrintStream;

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
				teacher.setStatus("attended 2020 term training");
			}
		}			
		
	}
	
	// disapprove class request or training request 
	public void diapprove(Object obj) {
		if(obj instanceof ClassRequest) {// disapprove class request by set the status to 'Disapproved'		
			((ClassRequest) obj).setReqStatus(ClassRequest.status[2]);
		}
		// disapprove training request by clearing "pending" teachers in the training request list
		// teachers who have been approved before will not be affected
<<<<<<< HEAD
<<<<<<< HEAD

		if (obj instanceof ListOfTeacher) {
			ListOfTeacher trainingReq = (ListOfTeacher) obj;
			for (Teacher t : trainingReq.getTeachers()) {
				if (t.getStatus().equals("Pending"))
					trainingReq.removeTeacher(t);
			}
=======
=======
>>>>>>> parent of 790501d... final updated
		if(obj instanceof ListOfTeacher) {
			ListOfTeacher trainingReq=(ListOfTeacher)obj;
			for(Teacher t:trainingReq.getTeachers()) {
				if(t.getStatus().equals("pending"))
				trainingReq.removeTeacher(t);
<<<<<<< HEAD
>>>>>>> parent of 790501d... final updated
=======
>>>>>>> parent of 790501d... final updated
		}
			}
			
	}
	
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" PPT Director");
	}

}
