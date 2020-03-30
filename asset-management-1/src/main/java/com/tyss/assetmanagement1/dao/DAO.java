package com.tyss.assetmanagement1.dao;

import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.UserNotFoundException;

public interface DAO {

    /**
     * Returns a list of objects of UserDetails Type
     * 
     * @return List<UserDetails>
     */
	List<UserDetails> users();

	/**
	 * Returns a list of objects of Assets Type
	 * 
	 * @return List<Assets>
	 */
	List<Assets> assets();

	/**
	 * Returns a list of objects of RequestForm Type
	 * 
	 * @return List<RequestForm>
	 */
	List<RequestForm> requests();
	
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
	void addUser(UserDetails userDetails);
	
	/**
	 * Adds an object of Asset type into the database
	 * 
	 * @param assets
	 */
	void addAsset(Assets assets);
	
	/**
	 * Updates an existing asset's quantity in the database
	 * 
	 * @param assetID - Integer
	 * @param quantity - Integer
	 * @throws AssetNotFoundException
	 */
	void updateAsset(Integer assetID, Integer quantity) throws AssetNotFoundException;
	
	/**
	 * Adds an object of RequestForm type into the database
	 * 
	 * @param requestForm
	 */
	void addRequest(RequestForm requestForm);
	
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
	 * checks if an employee exists with the given user ID
	 * and returns 0 if true, 1 if the user ID is of a manager/user or the Admin
	 * -1 if the user ID does not exist in the database
	 * 
	 * @param empID
	 * @return Integer - (1/0/-1)
	 */
	Integer checkEmployee(Integer empID);
	
	/**
	 * checks if the asset is available in the database
	 * and returns a boolean state
	 * 
	 * @param assetID
	 * @return boolean
	 */
	boolean checkAsset(Integer assetID);
	
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
	 * @param password - String
	 */
	void changePassword(Integer userID, String password);

}

