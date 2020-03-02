package Main;

public class Main{
	public static void main(String[] args) {
		PTTModel model = new PTTModel();
		PTTView view = new PTTView(model);
		PTTController controller = new PTTController(model,view);
		model.createUser("1", "a", "ClassDirector");
		model.createUser("2", "b", "PTTDirector");
		model.createUser("3", "c", "Administrator");
		controller.start();
	}
}
