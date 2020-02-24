package Main;

public class Main {
	
	public static void main(String[] args) {
		PTTModel model = new PTTModel();
		PTTView view = new PTTView(model);
		PTTController controller = new PTTController(model,view);
		
		controller.login();
	}

}
