package User;

public class Date {
	private int dob_d;
	private int dob_m;
	private int dob_y;	
	public Date(int d, int m, int y) {
			dob_d = d;
	        dob_m = m;
	        dob_y = y;
	}
	
	// getters
	public int getDay() {
		return dob_d;
	}
	public int getMonth() {
		return dob_m;
	}
	public int getYear() {
		return dob_y;
	}
	public String toString() {
		return String.format("%02d/%02d/%d", dob_d,dob_m,dob_y);
	}
	
}
