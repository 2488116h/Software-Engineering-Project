package Community;

import java.util.ArrayList;

public class ListOfClassReq {
	
	private ArrayList<ClassRequest> ListOfCR;
	
	public ListOfClassReq() {
		ListOfCR=new ArrayList<>();
		
	}
	
	public void add(ClassRequest req) {
		ListOfCR.add(req);
	}
	
	public ClassRequest getClassReq(int index) {
		return ListOfCR.get(index);
	}
	
	public int getSize() {
		return ListOfCR.size();
	}
	
	public ArrayList<ClassRequest> submittedList() {
		ArrayList<ClassRequest> submittedList=new ArrayList<ClassRequest>();
		for(ClassRequest req:ListOfCR) {
			if(req.getReqStatus().equals(ClassRequest.status[0]))
				submittedList.add(req);
		}
		return submittedList;
	}
	

}
