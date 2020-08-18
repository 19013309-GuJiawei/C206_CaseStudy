import java.time.LocalDate;

public class Package {
// Jonathan 
	private int code;
	private String description;
	private LocalDate Start_Date;
	private LocalDate End_Date;
	private double amount;
	
	public Package(int code, String description, LocalDate Start_Date, LocalDate End_Date, double amount) {
		this.code = code;
		this.description = description;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
		this.amount = amount;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(LocalDate start_Date) {
		Start_Date = start_Date;
	}

	public LocalDate getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(LocalDate end_Date) {
		End_Date = end_Date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
