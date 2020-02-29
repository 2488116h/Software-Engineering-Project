package Community;

import java.io.PrintStream;
import java.util.ArrayList;

public class ListOfTeacher {

	private ArrayList<Teacher> teachers;

	public ListOfTeacher() {
		teachers = new ArrayList<>();
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void removeTeacher(Teacher teacher, int arg) {
		if (arg == 1) {
			teachers.clear();
		}
		teachers.remove(teacher);

	}

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
		for (Teacher t : teachers) {
			ps.print(teachers.indexOf(t) + 1 + " ");
			ps.println(t.toString());
		}
	}

	// check whether a teacher in the list or not
	public boolean containNIN(String NIN) {
		for (Teacher t : teachers) {
			return t.getNIN().equals(NIN);
		}
		return false;
	}

}
