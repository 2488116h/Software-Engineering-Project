package Main;



public class PTTView {
	
	private PTTModel model;
	
	public PTTView(PTTModel model) {
		this.model=model;
		model = new PTTModel();
	}
	
	
	public void enterUsername() {
		System.out.println("-------Login------\n Please Enter Your Username:");
	}
	
	public void enterPassword() {
		System.out.println("Please Enter Your Password:");
	}
	
	public void loginFailed() {
		System.out.println("Illegal Login. Please Check Your Username and Password");
	}
	
	public void logout() {
		System.out.println("Logout Successfully!");
	}
	
	public void menu(int role) {
		String[] menu= {
				"1.list all the class requests",
				"2.create new class requirement",			
				"2.check all the submitted requests",
				"3.logout"};
		System.out.println("-------Select Menu------");
		if(role==1) {
			System.out.println(menu[0]+"\n"+menu[1]+"\n"+menu[3]+"\n----\n"+"");
		
		}else{
			System.out.println(menu[0]+"\n"+menu[2]+"\n"+menu[3]+"\n----\n"+"");
		}
	}
	
	public void createReqTitle() {
		System.out.println("Please Input the title of request:");
	}
	
	public void createReqDetails() {
		System.out.println("Please Input the details of request:");
	}
	
	public void submitteReq() {
		System.out.println("-------Request Submitted------\n1.create new request\n2.return main menu");
	}
	
	public void listRequests() {
		model.getRequests().print(model.getRequests().getListOfCR());
	}
	
	public void approval_menu() {
		model.getRequests().print(model.getRequests().submittedList());
		System.out.println("-------Select Menu------\n1.approve\n2.disapprove");
	}
	
	public void noRequest() {
		System.out.println("There is no submitted requests!");
	}

}
