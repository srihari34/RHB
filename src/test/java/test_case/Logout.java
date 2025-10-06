package test_case;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Page_Objects.Login_page;

public class Logout {
	
	private static Logger log = LogManager.getLogger(Login.class);

	Login_page loginobj;

	public  void logoutUser() {
	
		log.info("Logout Test Case");
    	boolean logoutmethod = loginobj.logout();
    	if(logoutmethod == true)
    	{
    		Assert.assertEquals(logoutmethod, true);
    		log.info("Logout Sucessfull");
    	}
    	else
    	{
    		log.error("Logout Failed");
    	}
	}

}
