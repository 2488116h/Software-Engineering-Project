package Community;

import java.io.PrintStream;
import java.util.HashMap;

public class ClassRequest {

	private String reqTitle;
	private String reqDetail;
	public static String[] status= {"Submitted","Approved","Disapproved"};
	private String reqStatus;
	
	public ClassRequest(String reqTitle,String reqDetail) {
		
		this.reqTitle=reqTitle;
		this.reqDetail=reqDetail;

		HashMap<String,String> req=new HashMap<>();
		req.put("Title", reqTitle);
		req.put("Description", reqDetail);
		reqStatus=status[1];
		req.put("Status", reqStatus);
	}


	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	
	public void print(PrintStream ps) {
		ps.println(reqTitle+"\n-----\n"+reqDetail+"\n-----\n"+reqStatus);
	}
	
	

}
