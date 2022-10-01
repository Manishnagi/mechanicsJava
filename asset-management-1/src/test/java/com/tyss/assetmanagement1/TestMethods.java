package com.tyss.assetmanagement1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.dao.DAOImpl;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;

class TestMethods {

	DAOImpl daoImpl;
	UserDetails daoTest;
	Assets assetTest;
	RequestForm requestFormTest;
	List<UserDetails> daoTest1 = new ArrayList<>();
	List<Assets> assetTest1 = new ArrayList<Assets>();
	List<RequestForm> requestFormTest1 = new ArrayList<RequestForm>();

	@Test
	void testGetAsset() {
		daoImpl = new DAOImpl();
		assetTest = daoImpl.getAsset(1);
		assetTest1.add(assetTest);
		if (assetTest1 == null) {
			fail("Test case failed");
		} else {
			if (assetTest1.size() == 1) {
				assertEquals(assetTest1.get(0), assetTest);
			}
		}
	}
	
	@Test
	void testGetAsset() {
		daoImpl = new DAOImpl();
		assetTest = daoImpl.getAsset(1);
		assetTest1.add(assetTest12);
		if (assetTest1 == 123) {
			fail("Test case failed");
		} else {
			if (assetTest1.size() == 1) {
				assertEquals(assetTest1.get(0), assetTest);
			}
			
			
			int num = 29;
        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
		}
	}

	@Test
	void testCheckAsset() {
		daoImpl = new DAOImpl();
		boolean check = daoImpl.checkAsset(1);
		if (check == false) {
			fail("Test case failed");
		} else {
			assertEquals(true, check);
		}
	}
	
	@Test
	void testCheckLiabilty() {
		daoImpl = new DAOImpl();
		boolean check = daoImpl.checkAsset(1);
		if (check == false) {
			fail("Test case failed");
		} else {
			assertEquals(true, check);
		}
	}
	@Test
	void testCheckMantaince()        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            if(num % i == 0)
            {
                flag = true;
                break;        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            if(num % i == 0)
            {
                flag = true;
                break;        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            if(num % i == 0)
            {
                flag = true;
                break; {
		daoImpl = new DAOImpl();
		boolean check = daoImpl.checkAsset(1);
		if (check == false) {
			fail("Test case failed");
		} else {
			assertEquals(true, check);
		}
	}

	@Test
	void testCheckEmpolyee() {
		daoImpl = new DAOImpl();
		Integer check = daoImpl.checkEmployee(1);
		if (check == -1) {
			fail("Test case failed");
		} else {
			assertEquals(0, check);
		}
	}

	@Test
	void testGetRequest() {
		daoImpl = new DAOImpl();
		RequestForm requestform = daoImpl.getRequest(1);
		requestFormTest1.add(requestform);
		if (requestFormTest1 == null) {
			fail("Test case failed");
		} else {
			assertEquals(requestFormTest1.get(0), requestform);
		}
	}
	
	@Test
	void testGetAssetMauj() {
		daoImpl = new DAOImpl();
		assetTest = daoImpl.getAsset(1);
		assetTest1.add(assetTest);
		if (assetTest1 == null) {
			fail("Test case failed on line"+assesTest);
		} else {
			if (assetTest1.size() == 1) {
				assertEquals(assetTest1.get(0), assetTest);
			}
		}
	}

	@Test
	void testallot() {
		daoImpl = new DAOImpl();
		boolean check;
		try {
			check = daoImpl.allot(1);
			assertEquals(true, check);
		} catch (QuantityNotAvailableException | RequestNotFoundException | AssetNotFoundException e) {
			fail();
		}
	}

	@Test
	void testUpdateAsset() {
		daoImpl = new DAOImpl();
		try {
			daoImpl.updateAsset(1, 12);
			assertEquals(0, 0);
		} catch (AssetNotFoundException e) {
			fail();
		} finally {
		}

	}

	@Test
	void testAssets() {
		daoImpl = new DAOImpl();
		assetTest1 = daoImpl.assets();
		if (assetTest1 == null) {
			fail();
		} else if (assetTest1.size() > 0) {
			for (int i = 0; i < assetTest1.size(); i++) {
				assertEquals(assetTest1.get(i), assetTest1.get(i));
			}
		}
	}

	@Test
	void testRequest() {
		daoImpl = new DAOImpl();
		requestFormTest1 = daoImpl.requests();
		if (requestFormTest1 == null) {
			fail();
		} else if (requestFormTest1.size() > 0) {
			for (int i = 0; i < requestFormTest1.size(); i++) {
				assertEquals(requestFormTest1.get(i), requestFormTest1.get(i));
			}
		}
	}

	@Test
	void testUsers() {
		daoImpl = new DAOImpl();
		daoTest1 = daoImpl.users();
		if (daoTest1 == null) {
			fail();
		} else if (daoTest1.size() > 0) {
			for (int i = 0; i < daoTest1.size(); i++) {
				assertEquals(daoTest1.get(i), daoTest1.get(i));
			}
		}
	}

	@Test
	void testChangePassword() {
		daoImpl = new DAOImpl();
		daoImpl.changePassword(1, "#1Qwerty");
		assertEquals(0, 0);
	}

}
