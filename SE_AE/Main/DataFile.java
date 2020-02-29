package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;



import User.Date;


public class DataFile {
	private PTTModel model;
	private File file = new File("data.csv");
	private Scanner data;
	private FileWriter writer;
	
	
	public DataFile(PTTModel model) {
		this.model=model;
		model = new PTTModel();

	}
	
	
	public void readFile() {
		
		try {
			
			data= new Scanner(file);
			String str="";
			while(data.hasNext()) {
				str+=data.nextLine();
			}
//			String[] request=str.split(",");
//			model.creatRequest(request[0], request[1]);

			
						
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public void classReqData() {
		
		writeFile();
	}
	
//	public void teacherData() {
//		writeFile("teacherList",model.getTeachers());
//	}
//	
//	public void trainingReqData() {
//		writeFile("trainingReq",model.getSuitTeachers());
//	}
	
	public void writeFile() {
		
		
		try {
			writer = new FileWriter(file);
			writer.write(model.classReqData());
			writer.write(model.getTeachers().toString());
			writer.write(model.getSuitTeachers().toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
