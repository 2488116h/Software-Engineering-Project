package Main;


import Community.*;


public class FindTeacher {// this class is useless
	
//	private PTTModel listOfRequests;
	private ListOfTeacher teachers, suitTeachers;
	
	public FindTeacher() {
		suitTeachers=new ListOfTeacher();
		
	}
	
	public void createSuitTeacher(Teacher suitteacher) {
		suitTeachers.addTeacher(suitteacher);
	}
	
	public ListOfTeacher getTeachers() {
		return teachers;
	}
	
	public ListOfTeacher getSuitTeachers() {
		return suitTeachers;
	}
	
//	public ListOfClassReq getRequsts() {
//		return listOfRequests.getRequests();
//	}
	
	

}
