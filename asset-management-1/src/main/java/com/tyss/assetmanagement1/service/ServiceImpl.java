package com.tyss.assetmanagement1.service;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.dao.DAO;
import com.tyss.assetmanagement1.repository.Dummy;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;
import com.tyss.assetmanagement1.util.factory.Factory;


public class ServiceImpl implements Service {

	DAO dao;
	
	public ServiceImpl() {
		dao = Factory.getDAO();
		Dummy.request(this);
		Dummy.approve(this);
	}
	
	
	@Override
	public List<UserDetails> getUsers() {
		return dao.users();
	}

	@Override
	public List<Assets> getAssets() {
		return dao.assets();
	}

	@Override
	public UserDetails getUser(String userName, String password) {		
		return dao.getUser(userName, password);
	}
	
	@Override
	public List<RequestForm> getRequests() {
		return dao.requests();
	}
	
	@Override
	public Assets getAsset(Integer assetID) {
		return dao.getAsset(assetID);
	}

	@Override
	public RequestForm getRequest(Integer requestID) {
		return dao.getRequest(requestID);
	}
	
	@Override
	public void addUser(UserDetails userDetails) {
		
		dao.users().add(userDetails);
	}

	@Override
	public void addAsset(Assets asset) {
		dao.assets().add(asset);
	}
	
	@Override
	public void updateAsset(Integer assetID, Integer quantity) throws AssetNotFoundException {
		dao.updateAsset(assetID, quantity);		
	}

	
	@Override
	public boolean checkAsset(Integer assetID) {
		return dao.checkAsset(assetID);
	}
	
	@Override
	public Integer addRequest(Integer empID, Integer managerID, Integer assetID, Integer quantity
			, String addNotes) throws AssetNotFoundException {		
		Integer check;
		check = dao.checkEmployee(empID);
		if (check != 0)
			return check;
		boolean asset = dao.checkAsset(assetID);
		if (!asset) {
			throw new AssetNotFoundException();
		} else {
			dao.addRequest(new RequestForm(empID, managerID, assetID, quantity, addNotes));
		}		
		return check;		
	}
	
	
	@Override
	public boolean allot(Integer requestID) throws QuantityNotAvailableException, RequestNotFoundException {
		return dao.allot(requestID);
	}
	
	
}
