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

	public ArrayList<ClassRequest> getListOfCR(){
		return ListOfCR;
	}

	public String toString(ArrayList<ClassRequest> list) {
		String output = "";
		for(ClassRequest req:list) 
			output+=req.toString()+ "\n";
		return output;
	}

	// print out the list with all class requests
//	public String toString() {
//		String output = "";
//		for(int i=0;i<ListOfCR.size();i++) {
//			output = output + ListOfCR.get(i).toString() + "\n";
//		}
//		return output;

//}


	
}
