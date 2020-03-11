package com.tyss.assetmanagement1.dao;

import java.util.ArrayList;
import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.repository.Dummy;

public class DAOImpl implements DAO {
	
	List<UserDetails> users;
	List<Assets> assets;
	List<RequestForm> requests;
	
	public DAOImpl() {
		// Taking hard coded input from Dummy
				users = Dummy.dummyUsers();
				assets = Dummy.dummyAssets();
				Dummy.allot(assets);
				requests = new ArrayList<>();
				/*System.out.println(users)
				System.out.println(assets)*/
	}

	@Override
	public List<UserDetails> users() {
		return users;
	}

	@Override
	public List<Assets> assets() {
		return assets;
	}

	@Override
	public List<RequestForm> requests() {
		return requests;
	}

	@Override
	public Integer checkEmployee(Integer empID) {
		for (UserDetails userDetails : users) {
			if (userDetails.getUserID().equals(empID)) {
				if(userDetails.getUserType().equalsIgnoreCase("employee"))
						return 0;
				else
					return -1;
			}
		}
		return 1;
	}

	@Override
	public Integer checkAsset(Integer assetID, Integer quantity) {
		for (Assets assets2 : assets) {
			if (assets2.getAssetID().equals(assetID) ) {
				if (assets2.getAssetQuantity() > quantity)
				 return 0;
				else 
					return -1;
			}
		}
		return 1;
	}
	
	
	

}
