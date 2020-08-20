
public class Customer {
	//Joshua
	private String name;
	private String email;
	private String password;
	private String status;
	private String role;

	public Customer(String name, String role, String password, String email, String status) {
		super();
		this.name = name;
		this.role = role;
		this.password = password;
		this.email = email;
		this.status = status;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
