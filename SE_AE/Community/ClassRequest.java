package Community;

public class ClassRequest {

	private String reqTitle;
	private String reqDetail;
	protected static String[] status= {"Submitted","Approved","Disapproved"};
	private String reqStatus;
	private  int reqNo;

	public ClassRequest(String reqTitle,String reqDetail) {

		this.reqTitle=reqTitle;
		this.reqDetail=reqDetail;
		this.reqStatus=status[0];
		
	}


	public int getReqNo() {
		return reqNo;
	}


	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}


	public String getReqStatus() {
		return reqStatus;
	}


	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}


	public String getReqTitle() {
		return reqTitle;
	}

	public String getReqDetail() {
		return reqDetail;
	}
	
	// @override toString()
	public String toString() {
		String output0 = "Request No: " + reqNo + "\n";
		String output1 = "Request Title: " + reqTitle + "\n";
		String output2 = "Request Detail: " + reqDetail + "\n";
		String output3 = "Request Status: " + reqStatus + "\n";
		return output0+output1+output2+output3;
	}
}
