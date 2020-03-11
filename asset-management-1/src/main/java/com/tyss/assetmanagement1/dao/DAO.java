package com.tyss.assetmanagement1.dao;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;

public interface DAO {

	List<UserDetails> users();
	List<Assets> assets();
	List<RequestForm> requests();
	Integer checkEmployee(Integer empID);
	Integer checkAsset(Integer assetID, Integer quantity);
}
