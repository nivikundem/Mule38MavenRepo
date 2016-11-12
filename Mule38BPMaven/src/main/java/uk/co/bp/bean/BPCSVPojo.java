package uk.co.bp.bean;

public class BPCSVPojo {
	
	private String TransactionRef;
	private String TransactionType;
	private String TransactionNumber;
	private String FirstName;
	private String LastName;
	private float Amount;
	
	
	public String getTransactionRef() {
		return TransactionRef;
	}
	public void setTransactionRef(String transactionRef) {
		TransactionRef = transactionRef;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public String getTransactionNumber() {
		return TransactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		TransactionNumber = transactionNumber;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}

	
	
	
	
	
}
