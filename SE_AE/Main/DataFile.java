package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataFile {
	private PTTModel model;
	private File file = new File("data.csv");
	private Scanner data;
	private FileWriter writer;

	public DataFile(PTTModel model) {
		this.model = model;
		model = new PTTModel();
		readFile();
	}

	public void readFile() {// read in file data

		try {

			data = new Scanner(file);
			String str = "";
			while (data.hasNext()) {
				str += data.nextLine() + "\n";
			}
			String[] read = str.split("\\*");
			
			String[] account=read[0].split("\n");// get class requests data
			for(int i = 1; i<account.length;i++) {
				String[] content = account[i].split(",");
				model.createUser(content[0], content[1], content[2]);// recreate user accounts
				
			}
			
			String[] classReq = read[1].split("\n");// get class requests data
			for (int i = 1; i < classReq.length; i++) {// read data ignoring the headline
				String[] content = classReq[i].split(",");
				model.creatRequest(content[1], content[2]);// recreate request and set the status				
				model.getClassRequests().getClassReq(i - 1).setReqStatus(content[3]);
			}

			String[] teachers = read[2].split("\n");// get the complete teacher list data
			for (int i = 1; i < teachers.length; i++) {// read data ignoring the headline
				String[] content = teachers[i].split(",");
				
				// recreate teacher and set the status
				model.registerTeacher(content[0], Integer.parseInt(content[3]), Integer.parseInt(content[4]),
						Integer.parseInt(content[5]), content[1], content[2]);
				model.getTeachers().getTeacher(i - 1).setStatus(content[6]);
			}

			String[] suitTeachers = read[3].split("\n");// get the suitable teacher list data
			for (int i = 1; i < suitTeachers.length; i++) {// read data ignoring the headline
				String[] content = suitTeachers[i].split(",");
				
				// add teacher to the suitable teacher list by matching the NIN character
				if (model.getTeachers().getTeacher(i - 1).getNIN().equals(content[2]))
					model.getSuitTeachers().addTeacher(model.getTeachers().getTeacher(i - 1));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeFile() {

		try {
			writer = new FileWriter(file);
			
			// write class request and teacher data into file during program running
			writer.write(model.accountData());
			writer.write(model.classReqData());
			writer.write(model.teacherData(model.getTeachers()));
			writer.write(model.teacherData(model.getSuitTeachers()));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
