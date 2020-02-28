package Community;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ListOfAttribute {
	
	private ArrayList<String> listofattri;
	
	public ListOfAttribute() {
		listofattri = new ArrayList<>();
	}
	
	public void addAttribute(String attriubte) {
		listofattri.add(attriubte);
	}
	
	public String getAttribute(int index) {
		return listofattri.get(index);
	}
	
	public ArrayList<String> getAttributeList(){
		return listofattri;
	}
	
	public void print(PrintStream ps) {
		Iterator<String> it = listofattri.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.print(s + " ");
		}
	}

}
