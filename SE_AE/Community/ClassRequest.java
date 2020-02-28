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
		this.reqStatus=reqStatus;
		req.put("Status", reqStatus);
	}


	public String getReqStatus() {
		return reqStatus;
	}


	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public void print(PrintStream ps) {
		ps.println("Title: "+reqTitle+"\nDesicription:\n"+reqDetail+"\nStatus: "+reqStatus);
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public String getReqDetail() {
		return reqDetail;
	}
	
	// @override toString()
	public String toString() {
		String output1 = "Request Title: " + reqTitle + " ; ";
		String output2 = "Request Detail: " + reqDetail + " ; ";
		String output3 = "Request Status: " + reqStatus + ".";
		return output1+output2+output3;
	}
}
