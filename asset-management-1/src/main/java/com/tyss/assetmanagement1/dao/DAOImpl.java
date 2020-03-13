package com.tyss.assetmanagement1.dao;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.repository.Database;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;

public class DAOImpl implements DAO {

	Database database;

	public DAOImpl() {
		// Taking hard coded input from Dummy
		database = new Database();
	}

	@Override
	public List<UserDetails> users() {
		return database.users();
	}

	@Override
	public List<Assets> assets() {
		return database.assets();
	}

	@Override
	public List<RequestForm> requests() {
		return database.requests();
	}

	@Override
	public UserDetails getUser(String userName, String password) {
		for (UserDetails userDetails : users()) {
			if (userDetails.checkLogin(userName, password)) {
				return userDetails;
			}
		}
		return null;
	}

	@Override
	public Assets getAsset(Integer assetID) {
		for (Assets assets2 : assets()) {
			if (assets2.getAssetID().equals(assetID))
				return assets2;
		}
		return null;
	}

	@Override
	public RequestForm getRequest(Integer requestID) {
		for (RequestForm requestForm : requests()) {
			if (requestForm.getRequestID().equals(requestID)) {
				return requestForm;
			}
		}
		return null;
	}

	@Override
	public Integer checkEmployee(Integer empID) {
		for (UserDetails userDetails : users()) {
			if (userDetails.getUserID().equals(empID)) {
				if (userDetails.getUserType().equalsIgnoreCase("employee"))
					return 0;
				else
					return -1;
			}
		}
		return 1;
	}

	@Override
	public boolean checkAsset(Integer assetID) {
		for (Assets assets2 : assets()) {
			if (assets2.getAssetID().equals(assetID))
				return true;
		}
		return false;
	}
	
	
	

	@Override
	public boolean allot(Integer requestID) throws QuantityNotAvailableException, RequestNotFoundException {
		RequestForm requestForm = getRequest(requestID);
		if(requestForm == null)
			throw new RequestNotFoundException();
		if (!requestForm.isAlloted()) {
			Assets assets = getAsset(requestForm.getAssetID());
			Integer quantity = requestForm.getQuantity();
			Integer allotedQuantity = assets.getAllotedM();
			Integer totalQuantity = assets.getAssetQuantity();
			if (totalQuantity >= quantity + allotedQuantity) {
				assets.allotEmployee(requestForm.getEmployeeID(), quantity);
				assets.allotManager(requestForm.getManagerID(), quantity);
				requestForm.allot();
				return true;
			}
			throw new QuantityNotAvailableException();
		}
		return false;
	}

	
	
	@Override
	public void addUser(UserDetails userDetails) {
		users().add(userDetails);
	}

	@Override
	public void addAsset(Assets asset) {
		assets().add(asset);

	}
	
	@Override
	public void updateAsset(Integer assetID, Integer quantity) throws AssetNotFoundException {
		Assets asset = getAsset(assetID);
		if (asset == null)
			throw new AssetNotFoundException();
		asset.setAssetQuantity(asset.getAssetQuantity() + quantity);		
	}

	@Override
	public void addRequest(RequestForm requestForm) {
		requests().add(requestForm);

	}

	

}
