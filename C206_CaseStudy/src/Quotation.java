
public class Quotation {
	
	//Alyssa//
	private int requestID;
	private int quotationID;
	private String renoCategory;
	private String description;
	private String designerName;
	private String startDate;
	private double totalAmount;
	
	public Quotation(int requestID, int quotationID, String renoCategory, String description, String designerName, String startDate, double totalAmount) {
		this.requestID = requestID;
		this.quotationID = quotationID;
		this.renoCategory = renoCategory;
		this.description = description;
		this.designerName = designerName;
		this.startDate = startDate;
		this.totalAmount = totalAmount;
	}
	
	public int getRequestID() {
		return requestID;
	}
	
	public int getQuotationID() {
		return quotationID;
	}
	
	public String getRenovationCategory() {
		return renoCategory;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDesignerName() {
		return designerName;
	}
	
	public String getEarliestStartDate() {
		return startDate;
	}
	
	public double getTotalQuoteAmount() {
		return totalAmount;
	}
}
