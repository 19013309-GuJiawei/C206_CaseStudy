
public class Customer {
	//Joshua
	public String name;
	public  int Contact_Number;
	public String email;

	public Customer(String name, int contact_Number, String email) {
		super();
		this.name = name;
		Contact_Number = contact_Number;
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setContact_Number(int contact_Number) {
		Contact_Number = contact_Number;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
