package Community;

import java.io.PrintStream;
import java.util.ArrayList;

public class ListOfTeacher {

	private ArrayList<Teacher> teachers;

	// teacher list constructor
	public ListOfTeacher() {
		teachers = new ArrayList<>();
	}

	/**
	 * add a teacher object to the list
	 * @param teacher: a teacher object
	 */
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	/**
	 * remove a teacher from the list
	 * @param teacher: a teacher object
	 */
	public void removeTeacher(Teacher teacher) {
		teachers.remove(teacher);

	}

	// Accessors
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
