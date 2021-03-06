import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	//jiawei
	private static final int searchByAppointmentDate = 3;
	private static final int searchByDesignerName = 2;
	private static final int searchByCustomerName = 1;
	private static final int SearchAppointment = 6;
	private static final int viewAllAppointment = 5;
	private static final int removeAppointment = 4;
	private static final int updateAppointment = 3;
	private static final int ViewAllDesigners = 1;
	private static final int addAppointment = 2;
	// JiaWei
	private static final int OPTION_QUIT = 4;
	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");
	private static final DateTimeFormatter date_format = DateTimeFormatter.ofPattern("d/MM/yyyy");
	private static final DateTimeFormatter time_format = DateTimeFormatter.ofPattern("H:mm");
	private static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	private static ArrayList<Designer> designerList = new ArrayList<Designer>();

	public static void main(String[] args) {

		// JiaWei
		LocalDate localDate1 = LocalDate.parse("20/08/2021", date_format);
		LocalTime localtime1 = LocalTime.parse("20:00", time_format);
		LocalTime localtime2 = LocalTime.parse("13:00", time_format);
		Appointment a1 = new Appointment(localDate1, localtime1, "Tim", "Address Blk1", "Customer123", "A1");
		Appointment a2 = new Appointment(LocalDate.now(), localtime2, "Tom", "Address Blk10", "Customer321", "A2");
		appointmentList.add(a1);
		appointmentList.add(a2);
		designerList.add(new Designer("Tim"));
		designerList.add(new Designer("Tom"));
		designerList.add(new Designer("Jason"));

		// ArrayList Package
		ArrayList<Package> packageList = new ArrayList<Package>();
		String start = "10/10/2020";
		String end = "10/11/2020";
		LocalDate startdate = LocalDate.parse(start, format);
		LocalDate enddate = LocalDate.parse(end, format);
		packageList.add(new Package(1, "This package is for testing", startdate, enddate, 100.50));

		// ArrayList RequestQuotation and Add
		ArrayList<RequestQuotation> requestquotationList = new ArrayList<RequestQuotation>();
		requestquotationList.add(
				new RequestQuotation(1, "HDB", 100, 999, "123@gmail.com", 100.1, null, "Whole house", "modern", "none"));

		// ArrayList Quotation (Alyssa)
		ArrayList<Quotation> manageQuotationList = new ArrayList<Quotation>();

		// ArrayList Customer
		ArrayList<Customer> userCustList = new ArrayList<Customer>();

		// JiaWei
		int option = 0;

		// JiaWei
		while (option != OPTION_QUIT) {

			menu();

			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all package
				C206_CaseStudy.viewAllPackage(packageList);

			} else if (option == 2) {
				// Login as Customer
				// Joshua
				CustomerMenu();

				int CustomerOption = Helper.readInt("Enter an option > ");

				if (CustomerOption == 1) {
					// Visitor account Registration
					Customer cu = inputCustomer();
					C206_CaseStudy.addCustomer(userCustList, cu);

				} else if (CustomerOption == 2) {
					// Request for Quotation
					RequestQuotation rq = inputRequestQuotation();
					C206_CaseStudy.addRequestQuotation(requestquotationList, rq);

				} else if (CustomerOption == 3) {
					// Manage Appointment
					Helper.line(80, "-");
					Helper.line(80, "-");
					System.out.println("Option 1: Add Appointment");
					System.out.println("Option 2: remove Appointment");
					System.out.println("Option 3: View all Appointment");

					int customerAppointment = Helper.readInt("Enter an option > ");

					if (customerAppointment == 1) {
						Helper.line(80, "-");
						addAppointment();

					} else if (customerAppointment == 2) {
						Helper.line(80, "-");
						removeAppointment();

					} else if (customerAppointment == 3) {
						viewAllAppointment(appointmentList);
					}

				} else {

					System.out.println("Invaild Option!");
				}

			} else if (option == 3) {

				// Login as Admin
				AdminMenue();

				int AdminOption = Helper.readInt("Enter an option > ");

				if (AdminOption == 1) {
					C206_CaseStudy.CustomerMenu();
					int CustomerOption = Helper.readInt("Enter an option > ");
					if (CustomerOption == 1) {
						// Manage Customer
						//Joshua
						C206_CaseStudy.ManageCustomer();
						int userCustOption = Helper.readInt("Enter an option > ");
						if (userCustOption == 1) {
							Customer cu = inputCustomer();
							C206_CaseStudy.addCustomer(userCustList, cu);
						}
						else if(userCustOption == 2) {
							C206_CaseStudy.viewCustomer(userCustList);
						}
						else if(userCustOption == 3) {
							String delete = Helper.readString("Enter Name To Delete: ");
							C206_CaseStudy.deleteCustomer(userCustList, delete);
						}
						
					} else if (CustomerOption == 2) {

						// Request for Quotation
						RequestQuotation rq = inputRequestQuotation();
						C206_CaseStudy.addRequestQuotation(requestquotationList, rq);

					} else if (CustomerOption == 3) {
						// Manage Appointment

					} else {
						System.out.println("Invaild Option!");
					}

					
					
					
					
					
					// Jonathan
					// Manage Package
				} else if (AdminOption == 2) {

					C206_CaseStudy.packageMenu();

					int PackageOption = Helper.readInt("Enter an option > ");

					if (PackageOption == 1) {
						Package pp = inputPackage();
						C206_CaseStudy.addPackage(packageList, pp);

					} else if (PackageOption == 2) {
						int delete = Helper.readInt("Enter code to delete > ");
						C206_CaseStudy.deletePackage(packageList, delete);

					} else if (PackageOption == 3) {
						C206_CaseStudy.updatePackage(packageList);
					}

					
					
					
					
					
					
					// Daven
					// Manage request quotation
				} else if (AdminOption == 3) {

					C206_CaseStudy.requestquotationMenu();
					int requestquotationOption = Helper.readInt("Enter an option > ");

					if (requestquotationOption == 1) {
						C206_CaseStudy.viewAllRequestQuotation(requestquotationList);

					} else if (requestquotationOption == 2) {
						int delete = Helper.readInt("Enter an code to delete > ");
						C206_CaseStudy.deleteRequestQuotation(requestquotationList, delete);
						
					} else if (requestquotationOption == 3) {
						C206_CaseStudy.updateRequestQuotation(requestquotationList);
					}

					// Manage Customer
				} else if (AdminOption == 4) {

					// Alyssa
					// Manage Quotation
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

						C206_CaseStudy.addQuotation(manageQuotationList, createQuotation(requestID, quotationID,
								renovationCat, description, name, startDate, totalAmount));
					}

					else if (quotationOption == 3) {
						int delete = Helper.readInt("Enter Quotation ID To Delete: ");
						C206_CaseStudy.deleteQuotation(manageQuotationList, delete);
					}

				} else if (AdminOption == 5) {
					// Manage Appointment
					adminAppointment();

				} else {
					System.out.println("Invaild Option!");
				}
			}
		}

	}

	private static void removeAppointment() {

		String customerName = Helper.readString("Enter Customer Name: ");
		String id = Helper.readString("Enter Appointment id: ");

		for (int i = 0; i < appointmentList.size(); i++) {
			if (customerName.equalsIgnoreCase(appointmentList.get(i).getCustomer())) {
				if (id.equalsIgnoreCase(appointmentList.get(i).getId())) {
					removeAppointment(appointmentList, appointmentList.get(i), customerName, id);
				} else {
					System.out.println("Invaild Appointment ID!");
				}

			} else {
				System.out.println("Customer not Found !");
			}
		}
	}

	private static void addAppointment() {

		String customerName = Helper.readString("Enter Customer Name: ");
		String address = Helper.readString("Enter Address: ");
		String designerName = Helper.readString("Enter Designer Name: ");
		String appointmentDate = Helper.readString("Enter appointment Date (dd/mm/yyyy): ");
		String appointmentTime = Helper.readString("Enter appointment Time (hh:ss): ");
		LocalDate localDate3 = LocalDate.parse(appointmentDate, date_format);
		LocalTime localtime3 = LocalTime.parse(appointmentTime, time_format);
		Appointment appointment1 = new Appointment(localDate3, localtime3, designerName, address, customerName,
				"A" + appointmentList.size());
		addAppointment(appointmentList, appointment1);
	}

	// JiaWei
	public static void setHeader(String header) {

		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// JiaWei
	public static void menu() {

		C206_CaseStudy.setHeader("Renovation ACE APP");
		System.out.println("1. View all package");
		System.out.println("2. Login as Customer");
		System.out.println("3. Login as Admin");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	// JiaWei
	private static void CustomerMenu() {

		C206_CaseStudy.setHeader("Customer Home Page");
		System.out.println("1. Visitor account Registration");
		System.out.println("2. Request for Quotation");
		System.out.println("3. Manage Appointment");
	}

	// Joshua
	private static void ManageCustomer() {

		C206_CaseStudy.setHeader("MANAGE CUSTOMERS");
		System.out.println("1. Add User Accounts");
		System.out.println("2. View all users");
		System.out.println("3. Delete users");
	}

	// JiaWei
	private static void AdminMenue() {

		C206_CaseStudy.setHeader("Admin Home Page");
		System.out.println("1. Manage Customer");
		System.out.println("2. Manage Package");
		System.out.println("3. Manage Request for Quotation");
		System.out.println("4. Manage Quotation");
		System.out.println("5. Manage Appointment");
	}

	// -----------------------------------------------------Menu---------------------------------------------------//

	// JiaWei
	private static void appointmentMenu() {
		Helper.line(80, "-");
		System.out.println("1. View All Designers");
		System.out.println("2. Make Appointment");
		System.out.println("3. Update Appointment");
		System.out.println("4. Delete Appointment");
		System.out.println("5. View Appointment");
		System.out.println("6. View Appointment");
		Helper.line(80, "-");

	}

	// Jonathan
	private static void packageMenu() {

		System.out.println("1. Add Package");
		System.out.println("2. Remove Package");
		System.out.println("3. Update Package");
	}

	// Daven
	private static void requestquotationMenu() {
		System.out.println("1. View all Request Quotation");
		System.out.println("2. Remove Request Quotation");
		System.out.println("3. Update Request Quotation");

	}

	// Alyssa
	public static void ManageQuotationMenu() {

		System.out.println("1. View All ID");
		System.out.println("2. Add Quotation");
		System.out.println("3. Delete Quotation");
	}

	// --------------------------------------------Manage Appointment---------------------------------------------------//

	// JiaWei
	private static void adminAppointment() {

		appointmentMenu();
		int appointmentOption = Helper.readInt("Enter an option > ");

		if (appointmentOption == ViewAllDesigners) {

			// View All Designers
			for (int i = 0; i < designerList.size(); i++) {
				System.out.println(designerList.get(i).getName());
			}

		} else if (appointmentOption == addAppointment) {
			addAppointment();

		} else if (appointmentOption == updateAppointment) {
			// Update Appointment
			String customerName = Helper.readString("Enter Customer Name: ");

			for (int i = 0; i < appointmentList.size(); i++) {

				if (customerName.equalsIgnoreCase(appointmentList.get(i).getCustomer())) {

					if (isAbleUpdate(appointmentList, appointmentList.get(i), customerName, LocalDate.now()) == true) {
						updateMenu();
						int adminOption = Helper.readInt("Enter Option: ");

						if (adminOption == 1) {
							String address = Helper.readString("Enter New Address: ");
							appointmentList.get(i).setAddress(address);

						} else if (adminOption == 2) {
							String appointmentDate1 = Helper.readString("Enter new appointment Date (dd/mm/yyyy): ");
							LocalDate localDate1 = LocalDate.parse(appointmentDate1, date_format);
							appointmentList.get(i).setDateOfAppointment(localDate1);

						} else if (adminOption == 3) {
							String appointmentTime1 = Helper.readString("Enter new appointment Time (hh:ss): ");
							LocalTime localtime2 = LocalTime.parse(appointmentTime1, time_format);
							appointmentList.get(i).setTimeOfAppointment(localtime2);

						} else if (adminOption == 4) {
							String designerName1 = Helper.readString("Enter New Designer Name: ");
							appointmentList.get(i).setDesignerName(designerName1);

						} else {
							System.out.println("Invaild Option!");
						}

					} else {
						System.out.println("Unable to update!");
					}

				}
			}

		} else if (appointmentOption == removeAppointment) {
			removeAppointment();

		} else if (appointmentOption == viewAllAppointment) {
			// View Appointment
			viewAllAppointment(appointmentList);

		} else if (appointmentOption == SearchAppointment) {
			searchAppointmentBy();

		} else {
			System.out.println("Invaild Option!");
		}
	}

	private static void searchAppointmentBy() {
		Helper.line(80, "-");
		System.out.println("Option 1: Search Appointment by Customer");
		System.out.println("Option 2: Search Appointment by Designer Name");
		System.out.println("Option 3: Search Appointment Appointment Date");
		Helper.line(80, "-");
		int option = Helper.readInt("Enter option: ");
		if (option == 1) {
			String customer = Helper.readString("Enter Customer Name: ");
			System.out.println(searchAppointment(appointmentList, option, customer));
		} else if (option == 2) {
			String desginer = Helper.readString("Enter Designer Name: ");
			System.out.println(searchAppointment(appointmentList, option, desginer));
		} else if (option == 3) {
			String date = Helper.readString("Enter Appointment Date(dd/mm/yyyy): ");
			System.out.println(searchAppointment(appointmentList, option, date));
		}
	}

	public static String searchAppointment(ArrayList<Appointment> appointmentList, int option, String searchBy) {
		String output = String.format("%-10s %-10s %-30s %-30s %-30s %-20s\n", "ID", "DATE", "TIME", "DESIGNER NAME",
				"ADDRESS", "CUSTOMER NAME");
		if (option == searchByCustomerName) {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (searchBy.equalsIgnoreCase(appointmentList.get(i).getCustomer())) {
					output = outputFormat(appointmentList, output, i);
				}
			}
		} else if (option == searchByDesignerName) {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (searchBy.equalsIgnoreCase(appointmentList.get(i).getDesignerName())) {
					output = outputFormat(appointmentList, output, i);
					
				}
			}
		} else if (option == searchByAppointmentDate) {
			LocalDate localDate = LocalDate.parse(searchBy, date_format);
			for (int i = 0; i < appointmentList.size(); i++) {
				if (localDate.isEqual(appointmentList.get(i).getDateOfAppointment())) {
					output = outputFormat(appointmentList, output, i);
				}
			}
		}

		return output;
	}

	private static String outputFormat(ArrayList<Appointment> appointmentList, String output, int i) {
		output += String.format("%-10s %-10s %-30s %-30s %-30s %-20s\n", appointmentList.get(i).getId(),
				appointmentList.get(i).getDateOfAppointment().toString(),
				appointmentList.get(i).getTimeOfAppointment().toString(),
				appointmentList.get(i).getDesignerName(), appointmentList.get(i).getAddress(),
				appointmentList.get(i).getCustomer());
		return output;
	}

	private static void updateMenu() {

		Helper.line(80, "-");
		Helper.line(80, "-");
		System.out.println("Option 1: Update Address");
		System.out.println("Option 2: Update appointment Date");
		System.out.println("Option 3: Update appointment Time");
		System.out.println("Option 4: Update Designer");
	}

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment a) {

		appointmentList.add(a);
		System.out.println("Appointment added!");

	}

	public static void removeAppointment(ArrayList<Appointment> appointmentList, Appointment a, String name,
			String id) {

		for (int i = 0; i < appointmentList.size(); i++) {

			if (name.equalsIgnoreCase(appointmentList.get(i).getCustomer())) {
				if (id.equalsIgnoreCase(appointmentList.get(i).getId())) {
					appointmentList.remove(a);
					System.out.println("Appointment removed!");
				} else {
					System.out.println("Invaild Appointment ID!");
				}

			} else {
				System.out.println("Customer not Found!");
			}
		}
	}

	public static String retrieveAllAppointment(ArrayList<Appointment> appointmentList) {

		String output = "";

		for (int i = 0; i < appointmentList.size(); i++) {

			output = outputFormat(appointmentList, output, i);
		}

		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {

		Helper.line(120, "-");
		String output = String.format("%-10s %-10s %-30s %-30s %-30s %-20s\n", "ID", "DATE", "TIME", "DESIGNER NAME",
				"ADDRESS", "CUSTOMER NAME");
		output += retrieveAllAppointment(appointmentList);
		System.out.println(output);
		Helper.line(120, "-");
	}

	public static boolean isAbleUpdate(ArrayList<Appointment> appointmentList, Appointment a, String name,
			LocalDate currentDate) {

		for (int i = 0; i < appointmentList.size(); i++) {

			if (name.equalsIgnoreCase(appointmentList.get(i).getCustomer())) {

				if (currentDate != appointmentList.get(i).getDateOfAppointment()
						&& currentDate.isBefore(appointmentList.get(i).getDateOfAppointment())) {
					return true;
				}
			}
		}

		return false;
	}

	// ------------------------------------------------Manage Package---------------------------------------------------//
	// Jonathan

	// Retrieve All Package
	public static String retrieveAllPackage(ArrayList<Package> packageList) {

		String output = "";

		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-10d %-30s %-15s %-15s $%-15.2f \n", packageList.get(i).getCode(),
					packageList.get(i).getDescription(), packageList.get(i).getStart_Date(),
					packageList.get(i).getEnd_Date(), packageList.get(i).getAmount());
		}

		return output;
	}

	// VIEW ALL Package
	public static void viewAllPackage(ArrayList<Package> packageList) {

		C206_CaseStudy.setHeader("Package LIST");
		String output = String.format("%-10s %-30s %-15s %-15s %-15s \n", "CODE", "DESCRIPTION", "START DATE",
				"END DATE", "AMOUNT");
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

			if (packageList.get(i).getCode() == code) {

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

			} else {
				System.out.println("Code not found!");
			}
		}
	}

	// DELETE PACKAGE
	public static void deletePackage(ArrayList<Package> packageList, int delete) {

		for (int i = 0; i < packageList.size(); i++) {

			if (packageList.get(i).getCode() == delete) {
				packageList.remove(i);
				System.out.println("Package removed!");
			}
		}
	}

	// ----------------------------------------Manage Request Quotation---------------------------------------------------//
	// DAVEN

	// VIEW ALL REQUEST QUOTATION
	public static String retrieveAllRequestQuotation(ArrayList<RequestQuotation> requestquotationList) {

		String output = "";

		for (int i = 0; i < requestquotationList.size(); i++) {

			output += String.format("%-10d %-15s %-10.2f %-10d %-20s %-10.2f %-15s %-15s %-15s %-15s\n",
					requestquotationList.get(i).getRQcode(),
					requestquotationList.get(i).getPropertyType(), requestquotationList.get(i).getAreaSize(),
					requestquotationList.get(i).getContact(), requestquotationList.get(i).getEmail(),
					requestquotationList.get(i).getBudget(), requestquotationList.get(i).getCompletedate(),
					requestquotationList.get(i).getRenovationType(), requestquotationList.get(i).getRenoStyle(),
					requestquotationList.get(i).getSRequest());

		}

		return output;
	}

	// VIEW REQUEST QUOTATION
	public static void viewAllRequestQuotation(ArrayList<RequestQuotation> requestquotationList) {

		C206_CaseStudy.setHeader("Request Quotation LIST");

		String output = String.format("%-10s %-15s %-10s %-10s %-20s %-10s %-15s %-15s %-15s %-15s \n", "RQCODE", "PROPERTY TYPE",
				"AREA SIZE", "CONTACT", "EMAIL", "BUDGET", "COMPLETE DATE", "RENO TYPE", "RENO STYLE", "URGET");

		output += retrieveAllRequestQuotation(requestquotationList);

		System.out.println(output);
	}

	// ADD REQUEST QUOTATION
	public static RequestQuotation inputRequestQuotation() {
		
		int RQcode = Helper.readInt("Enter RQcode> ");
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

		RequestQuotation rq = new RequestQuotation(RQcode, PT, Areasize, Contact, Email, Budget, completeDate, RT, RS, urgent);
		return rq;
	}

	public static void addRequestQuotation(ArrayList<RequestQuotation> requestquotationList, RequestQuotation rq) {

		requestquotationList.add(rq);
		System.out.println("Request Quotation added");
	}

	// DELETE REQUEST QUOTATION
	public static void deleteRequestQuotation(ArrayList<RequestQuotation> requestquotationList, int delete) {

		for (int i = 0; i < requestquotationList.size(); i++) {

			if (requestquotationList.get(i).getContact() == delete) {
				requestquotationList.remove(i);
				System.out.println("Request Quotation removed!");
			}else{
				System.out.println("Deletion failed");
		    }
		}
	}
	
	// UPDATE  REQUEST QUOTATION
	
	public static void updateRequestQuotation(ArrayList<RequestQuotation> requestquotationList) {

		int code = Helper.readInt("Enter the Request Quotation's code > ");

		for (int i = 0; i < requestquotationList.size(); i++) {

			if (requestquotationList.get(i).getRQcode() == code) {

				String PropertyType = Helper.readString("Enter new Property Type > ");
				double AreaSize = Helper.readDouble("Enter new Area Size> ");
				int Contact = Helper.readInt("Enter new Contact> ");
				String email = Helper.readString("Enter new email > ");
				double budget = Helper.readDouble("Enter new budget > ");
				String completedate = Helper.readString("Enter new complete date > ");
				LocalDate date = LocalDate.parse(completedate, format);
				String rT = Helper.readString("Enter new renovation type > ");
				String renoStyle = Helper.readString("Enter renovation style > ");
				String SRequest = Helper.readString("Is it urget? > ");
				

				requestquotationList.get(i).setPropertyType(PropertyType);
				requestquotationList.get(i).setAreaSize(AreaSize);
				requestquotationList.get(i).setContact(Contact);
				requestquotationList.get(i).setEmail(email);
				requestquotationList.get(i).setBudget(budget);
				requestquotationList.get(i).setCompletedate(date);
				requestquotationList.get(i).setRenovationType(rT);
				requestquotationList.get(i).setRenoStyle(renoStyle);
				requestquotationList.get(i).setSRequest(SRequest);

				System.out.println("Request Quotation updated");

			} else {
				System.out.println("Code not found!");
			}
		}
	}
	

	// -----------------------------------------------Manage Quotation---------------------------------------------------//
	// Alyssa
	// Retrieve Quotations
	public static String retreiveAllQuotation(ArrayList<Quotation> manageQuotationList) {

		String output = "";

		for (int i = 0; i < manageQuotationList.size(); i++) {

			output += String.format("%-10d %-10d %-10s %-10s %-10s %-10s %-10.2f \n",
					manageQuotationList.get(i).getRequestID(), manageQuotationList.get(i).getQuotationID(),
					manageQuotationList.get(i).getRenovationCategory(), manageQuotationList.get(i).getDescription(),
					manageQuotationList.get(i).getDesignerName(), manageQuotationList.get(i).getEarliestStartDate(),
					manageQuotationList.get(i).getTotalQuoteAmount());
		}

		return output;
	}

	// View Quotations
	public static void viewAllQuotation(ArrayList<Quotation> manageQuotationList) {

		C206_CaseStudy.setHeader("MANAGE QUOTATION LIST");

		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", "REQUEST_ID", "QUOTATION_ID",
				"RENOVATION CATEGORY", "DESCRIPTION", "DESIGNER NAME", "EARLIEST START DATE", "TOTAL QUOTATION AMOUNT");

		output += retreiveAllQuotation(manageQuotationList);
		System.out.println(output);
	}

	// Add Quotations
	public static Quotation createQuotation(int requestID, int quotationID, String renovationCat, String desc,
			String name, String startDate, double totalAmt) {

		Quotation q = new Quotation(requestID, quotationID, renovationCat, desc, name, startDate, totalAmt);
		return q;
	}

	public static void addQuotation(ArrayList<Quotation> manageQuotationList, Quotation q) {
		manageQuotationList.add(q);
		System.out.println("Quotation Added");
	}

	// Delete Quotations

	public static void deleteQuotation(ArrayList<Quotation> manageQuotationList, int delete) {

		for (int i = 0; i < manageQuotationList.size(); i++) {
			if (manageQuotationList.get(i).getQuotationID() == delete) {
				manageQuotationList.remove(i);
				System.out.println("Quotation Removed!");
			}
		}
	}

	// ----------------------------------------Manage Customer-----------------------------------------------------------------------
	// Joshua
	public static Customer inputCustomer() {

		String uName = Helper.readString("Enter name> ");
		String uRole = Helper.readString("Enter role> ");
		String uEmail = Helper.readString("Enter email> ");
		String uPassword = Helper.readString("Enter password> ");
		String uStatus = Helper.readString("Enter status> ");

		Customer uCust = new Customer(uName, uRole, uEmail, uPassword, uStatus);
		return uCust;
	}

	// Add Customer
	public static void addCustomer(ArrayList<Customer> userCustList, Customer uCust) {

		userCustList.add(uCust);
		System.out.println("Customer added!");
	}

	// Retrieve Customer
	public static String retrieveAllCustomer(ArrayList<Customer> userCustList) {

		String output = "";

		for (int i = 0; i < userCustList.size(); i++) {

			output += String.format("%-10s %-20s %-10s %-10s %-20s\n", userCustList.get(i).getName(),
					userCustList.get(i).getRole(), userCustList.get(i).getEmail(), userCustList.get(i).getPassword(),
					userCustList.get(i).getStatus());
		}

		return output;
	}

	// View Customer
	public static void viewCustomer(ArrayList<Customer> userCustList) {

		String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "NAME", "ROLE", "PASSWORD", "EMAIL", "STATUS");
		output += retrieveAllCustomer(userCustList);
		System.out.println(output);
	}

	// Delete Customer
	public static void deleteCustomer(ArrayList<Customer> userCustList, String delete) {

		for (int i = 0; i < userCustList.size(); i++) {

			if (userCustList.get(i).getName().equals(delete)) {
				userCustList.remove(i);
				System.out.println("Customer removed!");
			}
		}
	}

}
