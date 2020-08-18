//Daven

import java.time.LocalDate;

public class RequestQuotation {
	private String PropertyType;
	private double AreaSize;
	private int Contact;
	private String email;
	private double budget;
	private LocalDate completedate;
	private int renovationType;
	private String renoStyle;
	private String SRequest;
	
	public RequestQuotation(String PropertyType, double AreaSize,int Contact,String email,double budget,
			LocalDate completedate,int renovationType,String renoStyle,String SRequest){
		
		this.PropertyType = PropertyType;
		this.AreaSize = AreaSize;
		this.Contact = Contact;
		this.email = email;
		this.budget = budget;
		this.completedate = completedate;
		this.renovationType = renovationType;
		this.renoStyle = renoStyle;
		this.SRequest = SRequest;
		
	}

	public String getPropertyType() {
		return PropertyType;
	}

	public void setPropertyType(String propertyType) {
		PropertyType = propertyType;
	}

	public double getAreaSize() {
		return AreaSize;
	}

	public void setAreaSize(double areaSize) {
		AreaSize = areaSize;
	}

	public int getContact() {
		return Contact;
	}

	public void setContact(int contact) {
		Contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public LocalDate getCompletedate() {
		return completedate;
	}

	public void setCompletedate(LocalDate completedate) {
		this.completedate = completedate;
	}

	public int getRenovationType() {
		return renovationType;
	}

	public void setRenovationType(int renovationType) {
		this.renovationType = renovationType;
	}

	public String getRenoStyle() {
		return renoStyle;
	}

	public void setRenoStyle(String renoStyle) {
		this.renoStyle = renoStyle;
	}

	public String getSRequest() {
		return SRequest;
	}

	public void setSRequest(String sRequest) {
		SRequest = sRequest;
	}
	
	
}
