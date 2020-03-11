package com.tyss.assetmanagement1.beans;

@SuppressWarnings("unused")
public class RequestForm {

	private static Integer count = 1;

	private Integer requestID;
	private Integer assetID;
	private Integer employeeID;
	private Integer quantity;
	private String additionalNotes;

	public RequestForm() {

	}

	public RequestForm(Integer employeeID, Integer assetID, Integer quantity, String additionalNotes) {
		this.requestID = count++;
		this.assetID = assetID;
		this.employeeID = employeeID;
		this.quantity = quantity;
		this.additionalNotes = additionalNotes;
	}

	
	
	public Integer getRequestID() {
		return requestID;
	}

	public void setRequestID(Integer requestID) {
		this.requestID = requestID;
	}

	public Integer getAssetID() {
		return assetID;
	}

	public void setAssetID(Integer assetID) {
		this.assetID = assetID;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	@Override
	public String toString() {
		return "RequestForm [requestID=" + requestID + ", assetID=" + assetID + ", employeeID=" + employeeID
				+ ", quantity=" + quantity + ", \nadditionalNotes-->\n" + additionalNotes + "]";
	}
	
	
	

}
