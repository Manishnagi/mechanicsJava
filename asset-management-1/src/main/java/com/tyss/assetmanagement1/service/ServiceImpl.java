package com.tyss.assetmanagement1.service;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.dao.DAO;
import com.tyss.assetmanagement1.util.PasswordEncoder;
import com.tyss.assetmanagement1.util.Validations;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.InvalidPasswordException;
import com.tyss.assetmanagement1.util.exceptions.InvalidUsernameException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;
import com.tyss.assetmanagement1.util.factory.Factory;

public class ServiceImpl implements Service {

	DAO dao;

	public ServiceImpl() {
		dao = Factory.getDAO();
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
	public List<RequestForm> getRequests() {
		return dao.requests();
	}

	@Override
	public UserDetails getUser(String userName, String password) throws InvalidPasswordException {
		for (UserDetails user : dao.users()) {
			if (user.getUserName().equals(userName)) {
				if (PasswordEncoder.checkPassword(password, user.getPassword())) {
					return user;
				} else {
					throw new InvalidPasswordException("Keep it real man");
				}
			}
		}
		return null;
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
	public void addUser(UserDetails userDetails) throws InvalidUsernameException {
		if (!Validations.validUsername(userDetails.getUserName()))
			throw new InvalidUsernameException();
		userDetails.setPassword(PasswordEncoder.encodedPassword(userDetails.getPassword()));
		dao.addUser(userDetails);
	}

	@Override
	public void addAsset(Assets asset) {
		dao.addAsset(asset);
	}

	@Override
	public void updateAsset(Integer assetID, Integer quantity) throws AssetNotFoundException {
		dao.updateAsset(assetID, quantity);
	}

	@Override
	public Integer addRequest(Integer empID, Integer managerID, Integer assetID, Integer quantity, String addNotes)
			throws AssetNotFoundException {
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
	public boolean allot(Integer requestID)
			throws QuantityNotAvailableException, RequestNotFoundException, AssetNotFoundException {
		return dao.allot(requestID);
	}

	@Override
	public void changePassword(Integer userID, String password) throws InvalidPasswordException {
		if (!Validations.validPassword(password))
			throw new InvalidPasswordException(
					"Password must contain a lower case, upper case, digit and a special character");
		dao.changePassword(userID, PasswordEncoder.encodedPassword(password));
	}

}
