import java.time.LocalDate;

public class Package {
// Jonathan
	private String code;
	private String description;
	private LocalDate Start_Date;
	private LocalDate End_Date;
	private int amount;
	
	public Package(String code, String description, LocalDate Start_Date, LocalDate End_Date, int amount) {
		this.code = code;
		this.description = description;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}