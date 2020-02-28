package Community;

import java.io.PrintStream;

import User.Date;
import User.Account;

public class PTTDirector extends Account{
	
	
	public PTTDirector(String u, String p) {
		super(u, p);
	}
	
	public void approve(ClassRequest request) {
		request.setReqStatus(ClassRequest.status[1]);
	}
	
	public void diapprove(ClassRequest request) {
		request.setReqStatus(ClassRequest.status[2]);
	}
	
	
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" PPT Director");
	}

}
