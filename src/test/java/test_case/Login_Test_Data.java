package test_case;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Page_Objects.Login_page;
import base.Base_Class;
import utilities.ReadExcelData;

public class Login_Test_Data extends Base_Class {

	private static Logger log = LogManager.getLogger(Login_Test_Data.class);

	Login_page loginobj;

	@Test(priority = 1)
	public void logoutMainUser() throws IOException {
		log.info("Logout for the User");
		loginobj = new Login_page(obj);
		boolean logoutmethod = loginobj.logout();
		try {
			Assert.assertTrue(logoutmethod, "User was not Logout successfully!");
		} catch (AssertionError e) {
			log.error("Assertion failed: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 2, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = Login_Test_Data.class)
	public void Login_Test(String username, String password, String errormessage)
			throws InterruptedException, IOException {
		log.info("Login Test Started");
		loginobj = new Login_page(obj);
		log.info("Attempting login for user: " + username);
		boolean loginSuccess = loginobj.login_Tests(username, password);
		
		if (errormessage != null && !errormessage.isEmpty()) {
			String actualmessage = loginobj.failed_Test();
			try {
				Assert.assertEquals(actualmessage, errormessage, "Error Message Does Not Matched");
			} catch (AssertionError e) {
				log.error("Assertion failed: " + e.getMessage());
				throw e;
			}
		} 
		else 
		{
		try {
				Assert.assertTrue(loginSuccess, "Login failed for valid credentials");
			} catch (AssertionError e) {
				log.error("Assertion failed: " + e.getMessage());
				throw e;
			}
			log.info("Login Success for User: " + username);
			log.info("Logout for the User");
			loginobj = new Login_page(obj);
			boolean logoutmethod = loginobj.logout();
			try {
				Assert.assertTrue(logoutmethod, "User was not Logout successfully!");
			} catch (AssertionError e) {
				log.error("Assertion failed: " + e.getMessage());
				throw e;
			}
		}
	}

	@DataProvider(name = "LoginCredentials")
	public Object[][] logindata() throws IOException {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\Utilites\\Logindata.xlsx",
				"Login_Test_Data");
		int rowCount = red.getRowCount();
		Object[][] data = new Object[rowCount - 1][3]; // username, password, errormessage
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = red.getCellData(i, 0);
			data[i - 1][1] = red.getCellData(i, 1);
			data[i - 1][2] = red.getCellData(i, 2);
		}
		return data;
	}

	@Test(priority = 3, enabled = true, dataProvider = "BlockLoginCredentials", dataProviderClass = Login_Test_Data.class)
	public void Block_User(String username, String password, String errormessage) throws InterruptedException, IOException 
	{
		log.info("BlockLoginCredentials");
		loginobj = new Login_page(obj);
		log.info("Attempting login for user: " + username);
		boolean loginSuccess = loginobj.login_Tests(username, password);
		if (errormessage != null && !errormessage.isEmpty()) {
			String actualmessage = loginobj.failed_Test();
			try {
				Assert.assertEquals(actualmessage, errormessage, "Error Message Does Not Matched");
			} catch (AssertionError e) {
				log.error("Assertion failed: " + e.getMessage());
				throw e;
			}

		} else {
			try {
				Assert.assertTrue(loginSuccess, "Login failed for valid credentials");
			} catch (AssertionError e) {
				log.error("Assertion failed: " + e.getMessage());
				throw e;
			}
			log.info("Login Success for User: " + username);
			log.info("Logout for the User");
			loginobj = new Login_page(obj);
			boolean logoutmethod = loginobj.logout();
			try {
				Assert.assertTrue(logoutmethod, "User was not Logout successfully!");
			} catch (AssertionError e) {
				log.error("Assertion failed: " + e.getMessage());
				throw e;
			}
		
		}

	}

	@DataProvider(name = "BlockLoginCredentials")
	public Object[][] Blocklogindata() throws IOException {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\Utilites\\Logindata.xlsx","Block_User");
		int rowCount = red.getRowCount();
		Object[][] data = new Object[rowCount - 1][3]; // username, password, errormessage
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = red.getCellData(i, 0);
			data[i - 1][1] = red.getCellData(i, 1);
			data[i - 1][2] = red.getCellData(i, 2);
		}
		return data;
	}

	@Test(priority = 4, dataProvider = "LoginCredentials1", dataProviderClass = Login_Test_Data.class)
	public void MainUserLogin(String username, String password) throws IOException {
		log.info("Main Users Login");
		Login loginobj1 = new Login();
		loginobj1.Login_Data(username, password);
		log.info("User Logged In");
	}

	@DataProvider(name = "LoginCredentials1")
	public Object[][] MainUserLogin() throws IOException {

		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\Utilites\\Logindata.xlsx","LoginData");
		int rowCount = red.getRowCount();
		Object[][] data = new Object[rowCount - 1][2]; // Assuming username/password columns
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = red.getCellData(i, 0);
			data[i - 1][1] = red.getCellData(i, 1);
		}

		return data;
	}
}
