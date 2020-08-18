
public class Customer {
	//Joshua
	private String name;
	private  int Contact_Number;
	private String email;
	private String password;
	private String status;

	public Customer(String name, int contact_Number, String email, String password, String status) {
		this.name = name;
		Contact_Number = contact_Number;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getContact_Number() {
		return Contact_Number;
	}

	public void setContact_Number(int contact_Number) {
		Contact_Number = contact_Number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
