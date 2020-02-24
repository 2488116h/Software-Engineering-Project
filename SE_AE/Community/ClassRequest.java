package Community;

import java.util.HashMap;

public class ClassRequest {

	public String[] status= {"Submitted","Approved","Disapproved"};
	private String reqStatus;
	
	public ClassRequest(String reqTitle,String reqDetail) {

		HashMap<String,String> req=new HashMap<>();
		req.put("Title", reqTitle);
		req.put("Description", reqTitle);
		reqStatus=status[1];
		req.put("Status", reqStatus);
	}


	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	
	

}
