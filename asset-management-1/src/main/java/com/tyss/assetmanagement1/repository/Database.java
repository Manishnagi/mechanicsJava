package com.tyss.assetmanagement1.repository;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;

public class Database {

	private static final List<UserDetails> USERS;
	private static final List<Assets> ASSETS;
	private static final List<RequestForm> REQUESTS;
	
	static {
		USERS = Dummy.dummyUsers();
		ASSETS = Dummy.dummyAssets();
		REQUESTS = Dummy.dummyRequests();
	}
	
	public List<UserDetails> users() {
		return USERS;
	}
	
	public List<Assets> assets() {
		return ASSETS;
	}
	
	public List<RequestForm> requests() {
		return REQUESTS;
	}

}
