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
				"2.check the teachers list",              
				"3.create new class requirement",		  //  Class Director functions
				"3.check all the submitted requests",     //  PTT Director functions
				"3.find suitable teachers",               //  Administrator functions
				"4.logout"                                //  Administrator functions
				};
		System.out.println("-------Select Menu------");
		if(role==1) {
			System.out.println(menu[0]+"\n"+menu[1]+"\n"+menu[2]+"\n"+menu[5]+"\n----\n"+"");
		
		}else if(role==2){
			System.out.println(menu[0]+"\n"+menu[1]+"\n"+menu[3]+"\n"+menu[5]+"\n----\n"+"");
		}
		else if(role==3){                                  // print Administrator functions
			System.out.println(menu[0]+"\n"+menu[1]+"\n"+menu[4]+"\n"+menu[5]+"\n----\n"+"");
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
	
	public void selectReq() {
		System.out.println("-------Select Requirement------\n1.class request\n2.training request\n3.return main menu");
	}
	
	public void listRequests() {
		model.getClassRequests().print(model.getClassRequests().getListOfCR());
	}
	
	public void submittedList_ClassReq() {
		model.getClassRequests().print(model.getClassRequests().submittedList());
		approval_menu();
	}
	
	public void submittedList_TrainReq() {
		listOfSuitTeacher();
		approval_menu();
	}
	public void approval_menu() {
		System.out.println("-------Select Menu------\n1.approve\n2.disapprove\n3.return Main Menu");
	}
	public void approval_result(int index) {
		if(index==1) {
			System.out.println("Approved Successfully!");
		}else if(index==2) {
			System.out.println("Rejected Successfully!");
		}	
	}
	

	public void noRequest() {
		System.out.println("There is no submitted requests!");
	}
	
	public void listOfTeacher() {
		System.out.println("-------List of Teacher------");
		for(int i =0; i< model.getTeachers().getTeachersSize();i++) {
			System.out.print(i+1+" ");
			model.getTeachers().getTeacher(i).print(System.out);
			System.out.println();
		}
		
	}
	
	public void listOfSuitTeacher() {
		System.out.println("-------List of Suitable Teacher------");
		for(int i =0; i< model.getSuitTeachers().getTeachersSize();i++) {
			System.out.print(i+1+" ");
			model.getSuitTeachers().getTeacher(i).print(System.out);
			System.out.println();
		}
		
		if(model.getSuitTeachers().getTeachersSize()==0)
			noRequest();
		
	}

	public void createSuitTeacher() {
		System.out.println("Please enter the index to add a teacher to list or enter '0' to return Main Menu");
	}
	
	public void addedTeacher() {
		System.out.println("-------Teacher added------\n add another teacher by enter the index or enter '0' to return Main Menu");
	}


}
