package Community;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ListOfTeacher {

	private ArrayList<Teacher> teachers;

	public ListOfTeacher() {
		teachers = new ArrayList<>();
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	
	public void removeTeacher(Teacher teacher,int arg) {
		if(arg==1) {
			teachers.clear();
		}
		teachers.remove(teacher);
		
	}
	
//	public ArrayList<Teacher> getSuitTeachers() {
//		return teachers;
//	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public Teacher getTeacher(int index) {
		return teachers.get(index);
	}

	public int getTeachersSize() {
		return teachers.size();
	}
	
	public void print(PrintStream ps) {
		Iterator<Teacher> it = teachers.iterator();
		while(it.hasNext()) {
			Teacher s = it.next();
			System.out.print(s + " ");
		}
	}

	// check whether a teacher in the list or not
	public boolean check(String NIN) {
		for(int i=0;i<teachers.size();i++) {
			if(teachers.get(i).getNIN() == NIN) {
				return true;
			}
		}
		return false;
	}

}
