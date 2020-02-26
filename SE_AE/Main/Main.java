package Main;


public class Main {
	
	public static void main(String[] args) {
		PTTModel model = new PTTModel();
		PTTView view = new PTTView(model);
		DataFile data = new DataFile(model);
		PTTController controller = new PTTController(model,view,data);
		
		controller.login();
		

	}

}
