package Community;

import java.util.ArrayList;
import java.util.List;

public class ListOfTeacher {
	private List<Teacher> teachers;
	
	// constructor
	public ListOfTeacher() {
		teachers = new ArrayList<Teacher>(0);
	}
	
	// check whether a teacher in the list or not
	public boolean check(String name) {
		for(int i=0;i<teachers.size();i++) {
			if(teachers.get(i).getName() == name) {
				return true;
			}
		}
		return false;
	}
	
	// add a teacher object in the end of the list
	public void add(Teacher t) {
		teachers.add(t);
	}
	
}
