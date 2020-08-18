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
				C206_CaseStudy.viewAllPackage(packageList); // jonathan 
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
	
//------------------------------------------------------------------------------- MANAGE PACKAGE--------------------------------------------------------------	
	
	// JONATHAN
	
// VIEW ALL PACKAGE
	
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		String output = "";

		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-10d %-30s %-10s %-10s %-20d\n", packageList.get(i).getCode(),
					packageList.get(i).getDescription(),packageList.get(i).getStart_Date(), packageList.get(i).getEnd_Date(), packageList.get(i).getAmount());
		}
		return output;
	}
	
	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("Package LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"START DATE", "END DATE","AMOUNT");
		 output += retrieveAllPackage(packageList);	
		System.out.println(output);
	}
	
	
// ADD PACKAGE	
	
	public static Package inputPackage() {
		int code = Helper.readInt("Enter code > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");
		String start = Helper.readString("Enter Start Date ");
		String end = Helper.readString("Enter End Date ");
		LocalDate startdate = LocalDate.parse(start, format);
		LocalDate enddate = LocalDate.parse(end, format);
		int amount = Helper.readInt("Enter amount of package");

		Package pp= new Package(code, description, startdate, enddate, amount);
		return pp;
		
	}
	public static void addPackage(ArrayList<Package> packageList, Package pp) {
		
		packageList.add(pp);
		System.out.println("Package added");
	}

}
