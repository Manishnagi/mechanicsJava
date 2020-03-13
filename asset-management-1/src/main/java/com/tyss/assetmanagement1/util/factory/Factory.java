package com.tyss.assetmanagement1.util.factory;

import com.tyss.assetmanagement1.dao.DAO;
import com.tyss.assetmanagement1.dao.DAOImpl;
import com.tyss.assetmanagement1.service.Service;
import com.tyss.assetmanagement1.service.ServiceImpl;

public class Factory {

	private Factory() {
		
	}
	
	public static DAO getDAO() {
		return new DAOImpl();
	}
	
	public static Service getService() {
		return new ServiceImpl();
	}

}
