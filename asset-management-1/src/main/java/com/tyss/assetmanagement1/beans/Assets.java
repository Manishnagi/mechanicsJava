package com.tyss.assetmanagement1.beans;

import java.util.HashMap;
import java.util.Map;

public class Assets {

	private static Integer count = 1;

	private String assetName;
	private Integer assetQuantity;
	private Double assetCost;
	private Integer assetID;
	private String assetDetails;

	// to track asset's accessibility/allotting
	private Map<Integer, Integer> managerAccessors;
	private Map<Integer, Integer> employeeAccessors;
	private Integer allotedM;
	private Integer allotedE;

	public Assets(String assetName, Integer assetQuantity, Double assetCost) {
		super();
		this.setAssetName(assetName);
		this.setAssetQuantity(assetQuantity);
		this.setAssetCost(assetCost);
		this.setAssetID(count++);
		assetDetails = "no comments available";
		managerAccessors = new HashMap<>();
		employeeAccessors = new HashMap<>();
		allotedM = 0;
		allotedE = 0;
	}

	public Assets() {
		// default constructor
	}
	
	public Integer getAssetID() {
		return assetID;
	}

	public void setAssetID(Integer assetID) {
		this.assetID = assetID;
	}

	public Integer getAllotedM() {
		return allotedM;
	}

	public Integer getAllotedE() {
		return allotedE;
	}

	public String getAssetName() {

		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Integer getAssetQuantity() {
		return assetQuantity;
	}

	public void setAssetQuantity(Integer assetQuantity) {
		this.assetQuantity = assetQuantity;
	}

	public Double getAssetCost() {
		return assetCost;
	}

	public void setAssetCost(Double assetCost) {
		this.assetCost = assetCost;
	}

	public String getassetDetails() {
		return assetDetails;
	}

	public void setassetDetails(String assetDetails) {
		this.assetDetails = assetDetails;
	}

	public void allotManager(Integer managerID, Integer quantity) {
		if (assetQuantity >= allotedM + quantity) {
			managerAccessors.put(managerID, quantity);
			allotedM += quantity;
		} else {
			System.out.println("Not enough assets to allot " + quantity);
		}
	}

	public void allotEmployee(Integer employeeID, Integer quantity) {
		if (assetQuantity >= allotedE + quantity) {
			employeeAccessors.put(employeeID, quantity);
			allotedE += quantity;
		} else {
			System.out.println("Not enough assets to allot " + quantity);
		}
	}

	public Integer getManagerNos(Integer managerID) {
		if (!managerAccessors.containsKey(managerID)) {
			return 0;
		}
		return managerAccessors.get(managerID);
	}

	public Integer getEmployeeNos(Integer employeeID) {
		if (!employeeAccessors.containsKey(employeeID)) {
			return 0;
		}
		return employeeAccessors.get(employeeID);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetCost == null) ? 0 : assetCost.hashCode());
		result = prime * result + ((assetName == null) ? 0 : assetName.hashCode());
		result = prime * result + ((assetQuantity == null) ? 0 : assetQuantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assets other = (Assets) obj;
		if (assetCost == null) {
			if (other.assetCost != null)
				return false;
		} else if (!assetCost.equals(other.assetCost))
			return false;
		if (assetName == null) {
			if (other.assetName != null)
				return false;
		} else if (!assetName.equals(other.assetName))
			return false;
		if (assetQuantity == null) {
			if (other.assetQuantity != null)
				return false;
		} else if (!assetQuantity.equals(other.assetQuantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assets [assetName=" + assetName + ", assetQuantity=" + assetQuantity + ", assetCost=" + assetCost
				+ ", assetID=" + assetID + ", assetDetails=" + assetDetails + "]";
	}

}
