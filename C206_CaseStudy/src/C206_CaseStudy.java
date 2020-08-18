
public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hello people :D
		//jiawei
		int option = 0;
		//jiawei
		while (option != OPTION_QUIT) {
			menu();
			if (option == 1) {
				
			}else if (option == 2) {
				CustomerMenu();
				int CustomerOption = 0;
				if (CustomerOption == 1) {
					
				}else if (CustomerOption == 2) {
					
				}
				
			}else if (option == 3 ) {
				AdminMenue();
				int AdminOption = 0;
				if (AdminOption == 1) {
					
				}else if (AdminOption == 2) {
					
				}else if (AdminOption == 3) {
					
				}else if (AdminOption == 4) {
					
				}else if (AdminOption == 5) {
					
				}else {
					
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
		System.out.println("1. Register an Account");
		System.out.println("2. Login as Customer");
		System.out.println("3. Login as Admin");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	//jiawei
	private static void CustomerMenu() {
		C206_CaseStudy.setHeader("Customer Home Page");
		System.out.println("1. Request for Quotation");
		System.out.println("2. Manage Appointment");
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

}
