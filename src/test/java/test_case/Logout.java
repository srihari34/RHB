package test_case;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page_Objects.Login_page;
import base.Base_Class;

public class Logout  extends Base_Class{
	
	private static Logger log = LogManager.getLogger(Login.class);

	Login_page loginobj;

	@Test
	public  void logoutUser() throws IOException {
	
		log.info("Logout Test Case");
		loginobj = new Login_page(obj); 
    	boolean logoutmethod = loginobj.logout();
    	Assert.assertTrue(logoutmethod, "User was not Logout successfully!");
	}

}
