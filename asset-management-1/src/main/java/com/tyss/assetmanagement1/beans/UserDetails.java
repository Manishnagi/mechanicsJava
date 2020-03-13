package com.tyss.assetmanagement1.beans;

public class UserDetails {
	
	private String userName;
	private Integer userID;
	private String userType;
	private String employeeID;
	private String password;
	
	private static Integer count = 0;
	
	public UserDetails(String userName, String password, String userType, String employeeID) {
		this.setEmployeeID(employeeID);
		this.setUserID(count++);
		this.setUserName(userName);
		this.setUserType(userType);
		this.setPassword(password);
	}

	public UserDetails() {
		
	}
	
	public boolean checkLogin(String userName, String password) {
		
		return this.userName.equalsIgnoreCase(userName) && this.password.equals(password);
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		//this.count = count;
	}


	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", userID=" + userID + ", userType=" + userType + ", employeeID="
				+ employeeID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		UserDetails other = (UserDetails) obj;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	
	
	
}
