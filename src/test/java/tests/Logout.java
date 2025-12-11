package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class Logout  extends BaseClass{
	
	private static Logger log = LogManager.getLogger(Login.class);

	LoginPage loginobj;

	@Test
	public  void logoutUser() throws IOException {
	
		log.info("Logout for the User");
		loginobj = new LoginPage(obj); 
    	boolean logoutmethod = loginobj.logout();
    	Assert.assertTrue(logoutmethod, "User was not Logout successfully!");
	}

}
