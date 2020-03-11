package com.tyss.assetmanagement1.service;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;

public interface Service {
	
	UserDetails getUser(String userName, String password);
	List<Assets> getAssets();
	List<RequestForm> getRequests();
	void addRequest(RequestForm requestForm);

}
