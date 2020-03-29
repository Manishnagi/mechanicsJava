package com.tyss.assetmanagement1.dao;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;

public interface DAO {

	List<UserDetails> users();
	List<Assets> assets();
	List<RequestForm> requests();
	Assets getAsset(Integer assetID);
	RequestForm getRequest(Integer requestID);
	void addUser(UserDetails userDetails);
	void addAsset(Assets assets);
	void updateAsset(Integer assetID, Integer quantity) throws AssetNotFoundException;
	void addRequest(RequestForm requestForm);
	Integer checkEmployee(Integer empID);
	boolean checkAsset(Integer assetID);
	boolean allot(Integer requestID) throws QuantityNotAvailableException, RequestNotFoundException, AssetNotFoundException;
	void changePassword(Integer userID, String password);

}

