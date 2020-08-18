
public class Customer {
	//Joshua
	private String name;
	private  int Contact_Number;
	private String email;
	private String password;
	private String status;
	private String role;

	public Customer(String name, String email, String password, String status, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
