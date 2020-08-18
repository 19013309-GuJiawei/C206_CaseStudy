
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;
	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyyy");

	public static void main(String[] args) {

		ArrayList<Package> packageList = new ArrayList<Package>();
		
		packageList.add(new Package(1, "This package is OK",  null, null, 100));

		
		//hello people :D
		//jiawei
		int option = 0;
		//jiawei
		while (option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				C206_CaseStudy.viewAllPackage(packageList);
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
					
				//Jonathan	
				}else if (AdminOption == 2) {
					C206_CaseStudy.packageMenu();
					int PackageOption = Helper.readInt("Enter an option > ");
					if (PackageOption == 1) {
						Package pp = inputPackage();
						C206_CaseStudy.addPackage(packageList, pp);
					}else if(PackageOption == 2) {
						C206_CaseStudy.deletePackage(packageList);
					}
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
		
	// JOnathan
		private static void packageMenu() {
			System.out.println("1. Add Package");
			System.out.println("2. Remove Package");
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
	
	
	
	//------------------------------------------------------------------------------- MANAGE PACKAGE--------------------------------------------------------------	
	
		// JONATHAN
		
	// VIEW ALL PACKAGE
		
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		String output = "";
		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-10d %-30s %-10s %-10s %-20d \n", packageList.get(i).getCode(),
					packageList.get(i).getDescription(), packageList.get(i).getStart_Date() , packageList.get(i).getEnd_Date() , packageList.get(i).getAmount());
	
		}
		return output;
	
	}
	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("Package LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "CODE", "DESCRIPTION",
				"START DATE", "END DATE","AMOUNT");
		 output += retrieveAllPackage(packageList);	
		System.out.println(output);
	}
	
	
// ADD PACKAGE	
	
	public static Package inputPackage() {
		int code = Helper.readInt("Enter code > ");
		String description = Helper.readString("Enter description > ");
		String start = Helper.readString("Enter Start Date> ");
		String end = Helper.readString("Enter End Date> ");
		LocalDate startdate = LocalDate.parse(start, format);
		LocalDate enddate = LocalDate.parse(end, format);
		int amount = Helper.readInt("Enter amount of package> ");

		Package pp = new Package(code, description, startdate, enddate, amount);
		return pp;
		
	}
	public static void addPackage(ArrayList<Package> packageList, Package pp) {
		
		packageList.add(pp);
		System.out.println("Package added");
	}
	
	
	
	
// DELETE PACKAGE
	public static void deletePackage(ArrayList<Package> packageList) {
		int code = Helper.readInt("Enter code to delete> ");
		
		for(int i = 0; i < packageList.size(); i++) {
			if(packageList.get(i).getCode() == code) {
				packageList.remove(i);
				System.out.println("Package removed!");
			}
		}
		
	}

	//---------------------------------------------------------------------------------------------------------------


}
