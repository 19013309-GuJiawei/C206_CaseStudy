import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;
	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");

	public static void main(String[] args) {


		ArrayList<Package> packageList = new ArrayList<Package>();
		String start = "10/10/2020";
		String end = "10/11/2020";
		LocalDate startdate = LocalDate.parse(start, format);
		LocalDate enddate = LocalDate.parse(end, format);		
		packageList.add(new Package(1, "This package is for testing",  startdate, enddate, 100.50));
		
		ArrayList<RequestQuotation> requestquotationList = new ArrayList<RequestQuotation>();
		requestquotationList.add(new RequestQuotation("HDB", 100, 999, "123@gmail.com", 100.1, null, "Whole house", "modern", "none" ));
	    
		ArrayList<Quotation> manageQuotationList = new ArrayList<Quotation>();

		//hello people :D
		//jiawei
		int option = 0;
		//jiawei
		while (option != OPTION_QUIT) {
			menu();
			option = Helper.readInt("Enter an option > ");
			if (option == 1) { 
				//View all package
				C206_CaseStudy.viewAllPackage(packageList);
			}else if (option == 2) {
				//Login as Customer
				//Joshua
				CustomerMenu();
				int CustomerOption = Helper.readInt("Enter an option > ");
				if (CustomerOption == 1) {
					//Visitor account Registration
				}else if (CustomerOption == 2) {
					RequestQuotation rq = inputRequestQuotation();
					C206_CaseStudy.addRequestQuotation(requestquotationList, rq);
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
					}else if(PackageOption == 3) {
						C206_CaseStudy.updatePackage(packageList);
					}
					//Manage Package
					
					// Daven
				}else if (AdminOption == 3) {
					C206_CaseStudy.requestquotationMenu();
					int requestquotationOption = Helper.readInt("Enter an option > ");
					
					if(requestquotationOption == 1) {
						C206_CaseStudy.viewAllRequestQuotation(requestquotationList);
					}else if(requestquotationOption == 2) {
						C206_CaseStudy.deleteRequestQuotation(requestquotationList);
					}

					//Manage Customer
				}else if (AdminOption == 4) {
					
	                  //Alyssa
                    //Manage Quotation
                    C206_CaseStudy.ManageQuotationMenu();
                   
                    int quotationOption = Helper.readInt("Enter an option > ");
                   
                    if (quotationOption == 1) {
                        C206_CaseStudy.viewAllQuotation(manageQuotationList);
                    }
                   
                    else if (quotationOption == 2) {
                        int requestID = Helper.readInt("Enter ID: ");
                        int quotationID = Helper.readInt("Enter Quotation ID: ");
                        String renovationCat = Helper.readString("Enter Renovation Category: ");
                        String description = Helper.readString("Enter Description Of Renovation Items: ");
                        String name = Helper.readString("Enter Designer Name: ");
                        String startDate = Helper.readString("Enter Start Date: ");
                        double totalAmount = Helper.readDouble("Enter Total Quotation Amount: ");
                        
                        C206_CaseStudy.addQuotation(manageQuotationList, createQuotation(requestID,quotationID, renovationCat, description, name, startDate, totalAmount));
                    }
                   
                    else if (quotationOption == 3) {
                        int delete = Helper.readInt("Enter Question ID To Delete: ");
                        C206_CaseStudy.deleteQuotation(manageQuotationList, delete);
                    }
                    
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
			System.out.println("3. Update Package");
		}
		
		private static void requestquotationMenu() {
			System.out.println("1. View all Request Quotation");
			System.out.println("2. Remove Request Quotation");

		}
	
		//Alyssa
		public static void ManageQuotationMenu() {
			
			System.out.println("1. View All ID");
			System.out.println("2. Add Quotation");
			System.out.println("3. Delete Quotation");
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

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment a) {
		// TODO Auto-generated method stub
		appointmentList.add(a);
		System.out.println("Appointment added!");
		
	}
	
	public static void removeAppointment(ArrayList<Appointment> appointmentList, Appointment a, String name) {
		// TODO Auto-generated method stub
		for (int i =0; i <appointmentList.size();i++) {
			if (name.equalsIgnoreCase(appointmentList.get(i).getCustomer())) {
				appointmentList.remove(a);
				System.out.println("Appointment removed!");
			}else {
				System.out.println("Customer not Found!");
			}
		}
	}
	
    public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {
		String output = "";
		for (int i = 0; i < appointmentList.size(); i++) {

			output += String.format("%-10s %-30s %-30s %-30s %-20s\n", appointmentList.get(i).getDateOfAppointment().toString(),
					appointmentList.get(i).getTimeOfAppointment().toString(), 
					appointmentList.get(i).getDesignerName(),
					appointmentList.get(i).getAddress(),appointmentList.get(i).getCustomer());
		}
		return output;
    	
	}
    
    public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("APPOINTMENT LIST");
		String output = String.format("%-10s %-30s %-30s %-30s %-20s\n", "DATE", "TIME",
				"DESIGNER NAME", "ADDRESS","CUSTOMER NAME");
		 output += retrieveAllAppointment(appointmentList);	
		System.out.println(output);
	}
    
    public static boolean isAbleUpdate(ArrayList<Appointment> appointmentList, Appointment a,String name, LocalDate currentDate) {
    	System.out.println(currentDate);
    	for (int i =0; i <appointmentList.size();i++) {
    		if (name.equalsIgnoreCase(appointmentList.get(i).getCustomer())) {
    			if (currentDate != appointmentList.get(i).getDateOfAppointment() && currentDate.isBefore(appointmentList.get(i).getDateOfAppointment())) {
    				System.out.println("Hi");
    				return true;
    			}
    		}
    	}
		return false;
		// TODO Auto-generated method stub
		
	}

//====================================================Manage Package========================================
	
	
	//JONATHAN 
	
	
	// VIEW ALL Package
	
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		String output = "";
		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-10d %-30s %-15s %-15s $%-15.2f \n", packageList.get(i).getCode(), packageList.get(i).getDescription(), packageList.get(i).getStart_Date(),
					packageList.get(i).getEnd_Date(), packageList.get(i).getAmount());
		}
		return output;
	
	}
	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("Package LIST");
		String output = String.format("%-10s %-30s %-15s %-15s %-15s \n", "CODE", "DESCRIPTION", "START DATE", "END DATE", "AMOUNT");
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
		double amount = Helper.readDouble("Enter amount of package> ");

		Package pp = new Package(code, description, startdate, enddate, amount);
		return pp;
		
	}
	public static void addPackage(ArrayList<Package> packageList, Package pp) {
		
		packageList.add(pp);
		System.out.println("Package added");
	}
	
	
	
	// UPDATE PACKAGE
	
	public static void updatePackage(ArrayList<Package> packageList) {
		int code = Helper.readInt("Enter the package's code > ");
		for (int i = 0; i < packageList.size(); i++) {
			if(packageList.get(i).getCode() == code) {
				String description = Helper.readString("Enter new description > ");
				String start = Helper.readString("Enter new Start Date> ");
				String end = Helper.readString("Enter new End Date> ");
				LocalDate startdate = LocalDate.parse(start, format);
				LocalDate enddate = LocalDate.parse(end, format);
				double amount = Helper.readDouble("Enter new amount of package> ");
				
				packageList.get(i).setDescription(description); 
				packageList.get(i).setStart_Date(startdate);
				packageList.get(i).setEnd_Date(enddate);
				packageList.get(i).setAmount(amount);
				
				System.out.println("Package updated");
				
			}else {
				System.out.println("Code not found!");
			}
		}
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

	//------------------------------------------------------------------------------- MANAGE REQUEST QUOTATION-----------------------------------------------------

	// DAVEN
	
	// VIEW ALL REQUEST QUOTATION
	
	public static String retrieveAllRequestQuotation(ArrayList<RequestQuotation> requestquotationList) {
		String output = "";
		for (int i = 0; i < requestquotationList.size(); i++) {

			output += String.format("%-15s %-10.2f %-10d %-20s %-10.2f %-15s %-15s %-15s %-15s\n", requestquotationList.get(i).getPropertyType(), requestquotationList.get(i).getAreaSize(),
					requestquotationList.get(i).getContact(), requestquotationList.get(i).getEmail(), requestquotationList.get(i).getBudget(),requestquotationList.get(i).getCompletedate(),
					requestquotationList.get(i).getRenovationType(), requestquotationList.get(i).getRenoStyle(), requestquotationList.get(i).getSRequest());
	
		}
		return output; 
	
	}
	public static void viewAllRequestQuotation(ArrayList<RequestQuotation> requestquotationList) {
		C206_CaseStudy.setHeader("Request Quotation LIST");
		String output = String.format("%-15s %-10s %-10s %-20s %-10s %-15s %-15s %-15s %-15s \n", "PROPERTY TYPE", "AREA SIZE",
				"CONTACT", "EMAIL","BUDGET", "COMPLETE DATE", "RENO TYPE", "RENO STYLE", "URGET");
		 output += retrieveAllRequestQuotation(requestquotationList);	
		System.out.println(output);
	}
	
	
// ADD REQUEST QUOTATION	
	
	public static RequestQuotation inputRequestQuotation() {
		
		String PT = Helper.readString("Enter Property Type > ");
		double Areasize = Helper.readDouble("Enter Areasize > ");
		int Contact = Helper.readInt("Enter Contact> ");
		String Email = Helper.readString("Enter Email> ");
		double Budget = Helper.readDouble("Enter Budget> ");
		String date = Helper.readString("Enter Complete Date");
		LocalDate completeDate = LocalDate.parse(date, format);
		String RT = Helper.readString("Enter Renovation Type > ");
		String RS = Helper.readString("Enter Renovation Style > ");
		String urgent = Helper.readString("Is it urgent > ");
		

		RequestQuotation rq= new RequestQuotation(PT, Areasize, Contact, Email, Budget, completeDate, RT, RS, urgent);
		return rq;
		
	}
	public static void addRequestQuotation(ArrayList<RequestQuotation> requestquotationList, RequestQuotation rq) {
		
		requestquotationList.add(rq);
		System.out.println("Request Quotation added");
	}
	
	
	
	
// DELETE REQUEST QUOTATION
	public static void deleteRequestQuotation(ArrayList<RequestQuotation> requestquotationList) {
		int code = Helper.readInt("Enter Contact of Request Quotationto delete> ");
		
		for(int i = 0; i < requestquotationList.size(); i++) {
			if(requestquotationList.get(i).getContact() == code) {
				requestquotationList.remove(i);
				System.out.println("Request Quotation removed!");
			}
		}

	}

//Alyssa

//VIEW ALL QUOTATION

public static String retreiveAllQuotation(ArrayList<Quotation> manageQuotationList) {
	
	String output = "";

	for (int i = 0; i < manageQuotationList.size(); i++) {
		
		output += String.format("%-10d %-10d %-10s %-10s %-10s %-10s %-10.2f \n", manageQuotationList.get(i).getRequestID(), manageQuotationList.get(i).getQuotationID(),
							manageQuotationList.get(i).getRenovationCategory(), manageQuotationList.get(i).getDescription(), manageQuotationList.get(i).getDesignerName(),
							manageQuotationList.get(i).getEarliestStartDate(),manageQuotationList.get(i).getTotalQuoteAmount());
	}
	
	return output;
}

public static void viewAllQuotation(ArrayList<Quotation> manageQuotationList) {
	
	C206_CaseStudy.setHeader("MANAGE QUOTATION LIST");
	
	String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", "REQUEST_ID", "QUOTATION_ID", "RENOVATION CATEGORY",
			"DESCRIPTION", "DESIGNER NAME", "EARLIEST START DATE", "TOTAL QUOTATION AMOUNT");
	
	output += retreiveAllQuotation(manageQuotationList);
	System.out.println(output);
}

//ADD QUOTATION
public static Quotation createQuotation(int requestID, int quotationID, String renovationCat, String desc, String name, String startDate, double totalAmt) {
    
    Quotation q  = new Quotation(requestID,quotationID,renovationCat,desc,name,startDate,totalAmt);
    return q;
}

public static void addQuotation(ArrayList<Quotation> manageQuotationList, Quotation q) {
	manageQuotationList.add(q);
	System.out.println("Quotation Added");
}

//DELETE QUOTATION

public static void deleteQuotation(ArrayList<Quotation> manageQuotationList, int delete) {
	
	for (int i=0; i<manageQuotationList.size(); i++) {
		if (manageQuotationList.get(i).getQuotationID() == delete) {
			manageQuotationList.remove(i);
			System.out.println("Quotation Removed!");
		}
	}
}
}


 //---------------------------------------------------------------------------------------------------------------


