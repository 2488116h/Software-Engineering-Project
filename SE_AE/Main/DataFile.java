package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class DataFile {
	private PTTModel model;
	private File file = new File("data.txt");
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
				str+=data.next();
			}
			
			JSONObject obj = JSON.parseObject(str);
			System.out.println(obj);
		
			JSONArray array_ClassReq = obj.getJSONArray("listOfCR");
			
			for(int i =0;i<array_ClassReq.size();i++) {
				String reqTitle= array_ClassReq.getJSONObject(i).getString("reqTitle");
				String reqDetail= array_ClassReq.getJSONObject(i).getString("reqDetail");
				String reqStatus= array_ClassReq.getJSONObject(i).getString("reqStatus");
				model.creatRequest(reqTitle, reqDetail);
				model.getRequests().getClassReq(i).setReqStatus(reqStatus);
			
			}
			

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public void classReqData() {
		
		writeFile(model.getRequests());
	}
	
	public void writeFile(Object o) {
		String str = JSON.toJSONString(o, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
		try {
			writer = new FileWriter(file);
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
