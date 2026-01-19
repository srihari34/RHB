package tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.LoginPage;
import utilities.ReadExcelData;

public class LoginTest extends BaseClass {

	private static Logger log = LogManager.getLogger(LoginTest.class);

	LoginPage loginobj;

	@Test(priority = 1)
	public void logoutMainUser() throws IOException {
		log.info("Logout for the User");
		loginobj = new LoginPage(obj);
		boolean logoutmethod = loginobj.logout();
		try {
			Assert.assertTrue(logoutmethod, "User was not Logout successfully!");
		} catch (AssertionError e) {
			log.error("Assertion failed: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 2, enabled = true, dataProvider = "LoginCredentials", dataProviderClass = LoginTest.class)
	@Description("Verify the Login Page with Different Scenarios")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyLoginTest(String username, String password, String errormessage)
			throws InterruptedException, IOException {
		log.info("Login Test Started");
		loginobj = new LoginPage(obj);
		log.info("Attempting login for user: " + username);
		boolean loginSuccess = loginobj.loginTests(username, password);
		
		if (errormessage != null && !errormessage.isEmpty()) {
			String actualmessage = loginobj.failedTest();
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
			loginobj = new LoginPage(obj);
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
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx",
				"LoginTestData");
		int rowCount = red.getRowCount();
		Object[][] data = new Object[rowCount - 1][3]; // username, password, errormessage
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = red.getCellData(i, 0);
			data[i - 1][1] = red.getCellData(i, 1);
			data[i - 1][2] = red.getCellData(i, 2);
		}
		return data;
	}

	@Test(priority = 3, enabled = true, dataProvider = "BlockLoginCredentials", dataProviderClass = LoginTest.class)
	@Description("Verify the Blocking the User After Multiple Wrong Login Attemps")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyblockUser(String username, String password, String errormessage) throws InterruptedException, IOException 
	{
		log.info("BlockLoginCredentials");
		loginobj = new LoginPage(obj);
		log.info("Attempting login for user: " + username);
		boolean loginSuccess = loginobj.loginTests(username, password);
		if (errormessage != null && !errormessage.isEmpty()) {
			String actualmessage = loginobj.failedTest();
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
			loginobj = new LoginPage(obj);
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
	public Object[][] blockLoginData() throws IOException {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","BlockUser");
		int rowCount = red.getRowCount();
		Object[][] data = new Object[rowCount - 1][3]; // username, password, errormessage
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = red.getCellData(i, 0);
			data[i - 1][1] = red.getCellData(i, 1);
			data[i - 1][2] = red.getCellData(i, 2);
		}
		return data;
	}

	@Test(priority = 4, dataProvider = "LoginCredentials1", dataProviderClass = LoginTest.class)
	public void mainUserLogin(String username, String password) throws IOException {
		log.info("Main Users Login");
		Login loginobj1 = new Login();
		loginobj1.verifyLoginData(username, password);
		log.info("User Logged In");
	}

	@DataProvider(name = "LoginCredentials1")
	public Object[][] mainUserLogin() throws IOException {

		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","LoginData");
		int rowCount = red.getRowCount();
		Object[][] data = new Object[rowCount - 1][2]; // Assuming username/password columns
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = red.getCellData(i, 0);
			data[i - 1][1] = red.getCellData(i, 1);
		}

		return data;
	}
}
