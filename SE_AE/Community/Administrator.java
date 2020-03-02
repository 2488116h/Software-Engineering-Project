package Community;

import java.io.PrintStream;

import User.*;

public class Administrator extends Account {
	//Administrator Constructor
	public Administrator(String u, String p) {
		super(u, p);
	}
	
	/**
	 * add suitable teacher to training list
	 * @param lot: list of teacher for training
	 * @param teacher: a teacher object
	 */
	public boolean createSuitTeacher(ListOfTeacher lot,Teacher teacher) {
		if(lot.getTeachers().contains(teacher)) {
			return false;
		}else {
			lot.addTeacher(teacher);
			return true;
		}		
		
	}
	
	/* create a new teacher: with default username and password, and attribute 
	* and add a teacher in the list
	*/
	public void createTeacher(String n, Date d, String g, String NIN,ListOfTeacher ListOfTRs) {
		Teacher tr = new Teacher(n, d, g, NIN);
		ListOfTRs.addTeacher(tr);
	}
	
	/**
	 * print the position of the user
	 */
	public void print(PrintStream ps) {
		super.print(ps);
		ps.print(" (Administrator)");
	}

}
