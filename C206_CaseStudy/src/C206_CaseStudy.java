
public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		
		//hello people :D
		//jiawei
		int option = 0;
		//jiawei
		while (option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				//View all package
			}else if (option == 2) {
				//Login as Customer
				CustomerMenu();
				int CustomerOption = Helper.readInt("Enter an option > ");
				if (CustomerOption == 1) {
					//Visitor account Registration
				}else if (CustomerOption == 2) {
					//Request for Quotation
				}else if (CustomerOption == 3) {
					//Manage Appointment
				}else {
					System.out.println("Invaild Option!");
				}
				
			}else if (option == 3 ) {
				//Login as Admin
				AdminMenue();
				int AdminOption = Helper.readInt("Enter an option > ");
				if (AdminOption == 1) {
					//Manage Customer
				}else if (AdminOption == 2) {
					//Manage Package
				}else if (AdminOption == 3) {
					//Manage Request for Quotation
				}else if (AdminOption == 4) {
					//Manage Quotation
				}else if (AdminOption == 5) {
					//Manage Appointment
				}else {
					System.out.println("Invaild Option!");
				}
			}
		}
		
	}
	
	//jiawei
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//jiawei
	public static void menu() {
		C206_CaseStudy.setHeader("Renovation ACE APP");
		System.out.println("1. View all package");
		System.out.println("2. Login as Customer");
		System.out.println("3. Login as Admin");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	//jiawei
	private static void CustomerMenu() {
		C206_CaseStudy.setHeader("Customer Home Page");
		System.out.println("1. Visitor account Registration");
		System.out.println("2. Request for Quotation");
		System.out.println("3. Manage Appointment");
	}
	
	//Jiawei
	private static void AdminMenue() {
		C206_CaseStudy.setHeader("Admin Home Page");
		System.out.println("1. Manage Customer");
		System.out.println("2. Manage Package");
		System.out.println("3. Manage Request for Quotation");
		System.out.println("4. Manage Quotation");
		System.out.println("5. Manage Appointment");
	}
	
	//-----------------------------------------------------Manage Appointment----------------------------------------
	//jiawei
		private static void appointmentMenu() {
			System.out.println("1. View All Designers");
			System.out.println("2. Make Appointment");
			System.out.println("3. Update Appointment");
			System.out.println("4. Delete Appointment");
			System.out.println("5. View Appointment");
		}
	
	//jiawei
	private static void manageAppointment() {
		appointmentMenu();
		int appointmentOption = Helper.readInt("Enter an option > ");
		if (appointmentOption == 1) {
			//View All Designers
		}else if (appointmentOption == 2) {
			//Make Appointment
		}else if (appointmentOption == 3) {
			//Update Appointment
		}else if (appointmentOption == 4) {
			//Delete Appointment
		}else if (appointmentOption == 5) {
			//View Appointment
		}else {
			
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------

}
