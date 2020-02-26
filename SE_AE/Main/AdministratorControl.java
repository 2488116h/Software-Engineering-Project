package Main;


import Community.*;


public class AdministratorControl {
	
	private PTTModel listOfRequests;
	private ListOfTeacher teachers, suitTeachers;
	
	public AdministratorControl() {
		suitTeachers=new ListOfTeacher();
		
	}
	
	public void createSuitTeacher(Teacher suitteacher) {
		suitTeachers.addataeacher(suitteacher);
	}
	
	public ListOfTeacher getTeachers() {
		return teachers;
	}
	
	public ListOfTeacher getSuitTeachers() {
		return suitTeachers;
	}
	
	public ListOfClassReq getRequsts() {
		return listOfRequests.getRequests();
	}
	
	

}
