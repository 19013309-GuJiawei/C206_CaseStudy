import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
	//Jiawei
	private LocalDate dateOfAppointment;
	private LocalTime timeOfAppointment;
	private String DesignerName;
	private String address;
	private String Customer;
	
	

	public Appointment(LocalDate dateOfAppointment, LocalTime timeOfAppointment, String designerName, String address,
			String customer) {
		this.dateOfAppointment = dateOfAppointment;
		this.timeOfAppointment = timeOfAppointment;
		DesignerName = designerName;
		this.address = address;
		Customer = customer;
	}
	

	public String getCustomer() {
		return Customer;
	}


	public void setCustomer(String customer) {
		Customer = customer;
	}


	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public LocalTime getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(LocalTime timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public String getDesignerName() {
		return DesignerName;
	}

	public void setDesignerName(String designerName) {
		DesignerName = designerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
