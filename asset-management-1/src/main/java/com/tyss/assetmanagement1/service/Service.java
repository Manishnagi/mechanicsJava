package com.tyss.assetmanagement1.service;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.InvalidPasswordException;
import com.tyss.assetmanagement1.util.exceptions.InvalidUsernameException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.UserNotFoundException;

public interface Service {
	
	
	UserDetails getUser(String userName, String password) throws InvalidPasswordException;
	
	 /**
     * Returns a list of objects of UserDetails Type
     * 
     * @return List<UserDetails>
     */
	List<UserDetails> getUsers();
	
	/**
	 * Returns a list of objects of Assets Type
	 * 
	 * @return List<Assets>
	 */
	List<Assets> getAssets();
	
	/**
	 * Returns a list of objects of RequestForm Type
	 * 
	 * @return List<RequestForm>
	 */
	List<RequestForm> getRequests();
	
	/**
	 * Returns an object of Assets type identified by the Asset's ID
	 * 
	 * @param Integer
	 * 
	 * @return Assets
	 */
	Assets getAsset(Integer assetID);

	/**
	 * Returns an object of RequestForm type identified by the Request form's ID
	 * 
	 * @param assetID - Integer
	 * 
	 * @return Assets
	 */
	RequestForm getRequest(Integer requestID);

	/**
	 * Adds an object of UserDetails type into the database
	 * 
	 * @param userDetails
	 */
	void addUser(UserDetails userDetails) throws InvalidUsernameException;

	/**
	 * Adds an object of Asset type into the database
	 * 
	 * @param assets
	 */
	void addAsset(Assets asset);

	/**
	 * Updates an existing asset's quantity in the database
	 * 
	 * @param assetID - Integer
	 * @param quantity - Integer
	 * @throws AssetNotFoundException
	 */
	void updateAsset(Integer assetID, Integer quantity) throws AssetNotFoundException;

	/**
	 * Remover an object of Assets type from the database
	 * identified by the aseet's ID
	 * 
	 * @param AssetID - Integer
	 * @throws AssetNotFoundException 
	 */
	void removeAsset(Integer AssetID) throws AssetNotFoundException;
	
	/**
	 * Remover an object of UserDetails type from the database
	 * identified by the user's ID
	 * 
	 * @param UserID - Integer
	 * @throws UserNotFoundException 
	 */
	void removeUser(Integer userID) throws UserNotFoundException;
	
	/**
	 * Adds an object of RequestForm type into the database
	 * 
	 * @param requestForm
	 * 
	 * @return Integer
	 */
	Integer addRequest(Integer empID, Integer managerID, Integer assetID, Integer quantity
			, String addNotes) throws AssetNotFoundException ;
	
	/**
	 * Confirms allocation of an asset based on the
	 * request form's ID. Returns false if it is already alloted
	 *  
	 * @param requestID
	 * @return boolean
	 * @throws QuantityNotAvailableException
	 * @throws RequestNotFoundException
	 * @throws AssetNotFoundException
	 */
	boolean allot(Integer requestID) throws QuantityNotAvailableException, RequestNotFoundException, AssetNotFoundException;
	
	/**
	 * changes password of the current user
	 * 
	 * @param userID - Integer
	 * @param password - Integer
	 * @throws InvalidPasswordException
	 */
	void changePassword(Integer userID, String password) throws InvalidPasswordException;

}
