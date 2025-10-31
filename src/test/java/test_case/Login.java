package test_case;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Page_Objects.Login_page;
import base.Base_Class;
import utilities.ReadExcelData;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login extends Base_Class {

	private static Logger log = LogManager.getLogger(Login.class);

	Login_page loginobj;
	
	@Test(dataProvider = "LoginCredentials", dataProviderClass = Login.class)

	public void Login_Data(String username, String password) throws IOException {
		log.info("Login User method Started");
		loginobj = new Login_page(obj);
		log.info("Login Page Method call");
		boolean isLoginSucessful = loginobj.login_Data(username, password);
		Assert.assertTrue(isLoginSucessful, "Login Failed For User : " + username);
		log.info("Login Test Completed Successfully");
	}

	@DataProvider(name = "LoginCredentials")
	public Object[][] logindata() throws IOException {
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

