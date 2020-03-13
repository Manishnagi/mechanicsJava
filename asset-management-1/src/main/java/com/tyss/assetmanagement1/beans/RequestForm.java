package com.tyss.assetmanagement1.beans;

@SuppressWarnings("unused")
public class RequestForm {

	private static Integer count = 1;

	private Integer requestID;
	private Integer assetID;
	private Integer employeeID;
	private Integer quantity;
	private String additionalNotes;
	private Integer managerID;
	private boolean alloted;

	public RequestForm() {

	}

	public RequestForm(Integer employeeID, Integer managerID, Integer assetID, Integer quantity, String additionalNotes) {
		alloted = false;
		requestID = count++;
		this.employeeID = employeeID;
		this.managerID = managerID;
		this.assetID = assetID;
		this.quantity = quantity;
		this.additionalNotes = additionalNotes;
	}
	
	
	public static Integer getCount() {
		return count;
	}

	public boolean isAlloted() {
		return alloted;
	}

	public void allot() {
		alloted = true;
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

	public Integer getManagerID() {
		return managerID;
	}

	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
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
		return "RequestForm [Alloted?=" + alloted +", requestID=" + requestID + ", assetID=" + assetID + ", employeeID=" + employeeID
				+ ", quantity=" + quantity + ", \nadditionalNotes-->" + additionalNotes + "]\n";
	}
	
	
	

}
