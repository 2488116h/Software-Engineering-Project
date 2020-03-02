package Main;



public class PTTView {

	private PTTModel model;

	public PTTView(PTTModel model) {
		this.model=model;
		model = new PTTModel();
	}

    /*
     * login and logout 
     */
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
	
	/*
     * main menu  
     */
	public void menu(int role) {
		String[] menu= {
				"1.check all the class requests",
				"2.check all the teachers",
				"3.create new class requirement",              //  Class Director functions
				"4.create new teacher",                        //  Class Director functions				
				"3.approve/disapprove requests",               //  PTT Director functions				
				"3.find suitable teachers to attend training", //  Administrator functions				
				"4.check suitable teacher list",
				"5.logout",
			        "5.create new teacher",                        //for administrator
			        "6.logout"                                     //for administrator
				};
		System.out.println("-------Select Menu------");
		if(role==1) {//  Class Director menu
			model.getClassDir().print(System.out);
			System.out.println("\n"+menu[0]+"\n"+menu[1]+"\n"+menu[2]+"\n"+menu[3]+"\n"+menu[7]);

		}else if(role==2){//  PTT Director menu
			model.getPTTDir().print(System.out);
			System.out.println("\n"+menu[0]+"\n"+menu[1]+"\n"+menu[4]+"\n"+menu[6]+"\n"+menu[7]);
		}
		else if(role==3){ //  Administrator menu   
			model.getAdmin().print(System.out);
			System.out.println("\n"+menu[0]+"\n"+menu[1]+"\n"+menu[5]+"\n"+menu[6]+"\n"+menu[8]+"\n"+menu[9]);
		}
	}

	/*
     * Class Director: create class request  
     */
	public void createReqTitle() {
		System.out.println("Please Input the title of request:");
	}

	public void createReqDetails() {
		System.out.println("Please Input the details of request:");
	}

	public void submitteReq() {
		System.out.println("Request Submitted!");
	}
			
	public void listRequests() {
		if(model.getClassRequests().getSize()!=0) {
			System.out.print("-------List of Class Request------\n"+model.getClassRequests().toString(model.getClassRequests().getListOfCR()));
		}else
			noItems();
	
	}
	
	/* PTT Director Menu: 
 	*  check all the requests and make approval
 	*/
	public void submittedList_ClassReq() {
		System.out.print("-------List of Submitted Request------\n"+model.getClassRequests().toString(model.getClassRequests().submittedList()));
		
	}
	
	public void approval_menu() {
		System.out.println("-------Select Menu------\n1.approve\n2.disapprove\n3.return Main Menu");
	}
	public void approval_result(int index) {
		if(index==1) {
			System.out.println("Approved Successfully!");
		}else if(index==2) {
			System.out.println("Disapproved Successfully!");
		}	
	}


	
	/* Class Director Menu: create teacher
	 	*  1. prompt for adding a teacher
	 	*  2. already exists
	 	*  3. create a new teacher
	 	*/
	// CD-1

	public void createTeacherMenu() {
		System.out.println("-------Select Menu------\n1.create new teacher\n2.return Main Menu");
		
	}
	
	public void createTeacher() {
		System.out.println("Please enter the Personal Information of this new Teacher");
	}
	// CD-2
	public void teacherExists(String teacherName) {
		System.out.println(teacherName + "is already in the List.");
	}
	// CD-3-1 ENTER Required Information of creating a new teacher
	public void createNIN() {
		System.out.println("Please enter his/her National Insurance Number:");
	}
	public void createName() {
		System.out.println("Please enter his/her name:");
	}
	public void createBirthDate() {
		System.out.println("Then, enter his/her date of birth in day, month, year sequence\n and it should be seprated by pressing Enter(only integer number allowed):");
	}
	public void createGender() {
		System.out.println("Finally, choose his/her gender:\n1.male\n2.female\n");
	}
	
	public void createFinined() {
		System.out.println("Created Successfully!");
	}
	
	// CD-3-2 the total teacher list
	public void listOfTeacher() {
		System.out.println("-------List of Teacher------");
		if(model.getTeachers().getTeachersSize()==0) {
			noItems();
		}else
			model.getTeachers().print(System.out);		
	}	
	
	
	/* Administrator Menu: adding suitable teachers according to the class requests 
 	*/

	public void listOfSuitTeacher() {
		System.out.println("-------List of Suitable Teacher------");
		
		if(model.getSuitTeachers().getTeachersSize()==0) {
			noItems();
		}else
			
		model.getSuitTeachers().print(System.out);
	}

	public void addSuitTeacher() {
		System.out.println("Please enter the index to add a teacher to list or enter '0' to return Main Menu");
	}
	public void addNewSuitTeacher() {
		this.listOfSuitTeacher();
		System.out.println("-------Teacher added------\n add another teacher by enter the index or enter '0' to return Main Menu");
	}
	
	
    // helper method
	public void noItems() {
		System.out.println("There is no items!");
	}



}
