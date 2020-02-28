package Main;


import java.util.HashMap;

import Community.*;


public class suitTeacherForm {// this class is useless
	
//	private PTTModel listOfRequests;
	private HashMap<ListOfTeacher,String> form;
	private ListOfTeacher suitTeachers;
	
	public suitTeacherForm(ListOfTeacher suitTeachers) {
		form=new HashMap<>();
		this.suitTeachers=suitTeachers;
		suitTeachers=new ListOfTeacher();

		form.put(suitTeachers,ClassRequest.status[0]);
		
	}
	
	public void createSuitTeacher(Teacher teacher) {
		suitTeachers.addTeacher(teacher);
	}
	
	
	public ListOfTeacher getSuitTeachers() {
		return suitTeachers;
	}

	public void setFormStatus(String status) {
		this.form.replace(suitTeachers, status);
	}
	
	

	

}
