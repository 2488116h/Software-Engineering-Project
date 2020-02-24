package Main;

public class PTTController {
	private PTTModel model;
	private PTTView view;
	
	public PTTController(PTTModel model,PTTView view) {
		this.model=model;
		this.view=view;
	}
	
	public void login() {
		if(model.login(view.login().get("username"), view.login().get("password"))) {
			
		};

	}

}
