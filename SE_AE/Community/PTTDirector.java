package Community;

import java.io.PrintStream;

import User.Date;
import User.User;

public class PTTDirector extends User{
	
	
	public PTTDirector(String u, String p, String n, Date d, String NIN) {
		super(u, p, n, d, NIN);
		// TODO Auto-generated constructor stub
	}
	
	public void approve(ClassRequest request) {
		request.setReqStatus(request.status[1]);
	}
	
	public void diapprove(ClassRequest request) {
		request.setReqStatus(request.status[2]);
	}
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" PPT Director");
	}

}
