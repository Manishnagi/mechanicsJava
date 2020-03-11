package com.tyss.assetmanagement1.service;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.dao.DAO;
import com.tyss.assetmanagement1.dao.DAOImpl;

public class ServiceImpl implements Service {

	DAO dao;
	
	public ServiceImpl() {
		dao = new DAOImpl();
	}
	
	@Override
	public UserDetails getUser(String userName, String password) {		
		for (UserDetails userDetails : dao.users()) {
			if (userDetails.checkLogin(userName, password)) {
				return userDetails;
			}
		}
		return null;
	}

	@Override
	public List<Assets> getAssets() {
		return dao.assets();
	}

	@Override
	public List<RequestForm> getRequests() {
		return dao.requests();
	}

	@Override
	public void addRequest(RequestForm requestForm) {
		
		Integer cA = dao.checkAsset(requestForm.getAssetID(), requestForm.getQuantity());
		Integer cE = dao.checkEmployee(requestForm.getEmployeeID());
		if (cA == 0 && cE == 0) {
			dao.requests().add(requestForm);
			System.out.println("\nRequest Successfully Made!");
			return;			
		}
		if (cA != 0) {
			if (cA == -1) {
				System.out.println("\n**Requested quantity not available!**");
			} else {
				System.out.println("\n**Invalid Asset ID**");
			}
		} else if (cE != 0) {
			if (cE == -1) {
				System.out.println("\n**Requests can be made only for employees**");
			} else {
				System.out.println("\n**Invalid Employee ID**");
			}
		}		
	}
	

	
}
