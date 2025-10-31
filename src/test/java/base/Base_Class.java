package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	private static Logger log = LogManager.getLogger(Base_Class.class);
	Properties prop = new Properties();

	public static WebDriver obj;

	@BeforeTest
	public void Launch_Browser() throws IOException {
		log.info("Application Started");
		log.info("===================");
		String userpath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(userpath + "\\src\\test\\resources\\Utilites\\Test_Data.properties");
		prop.load(fis);
		String browser = prop.getProperty("Browser").trim();
		if(browser.equalsIgnoreCase("chrome"))
		{
//	    	ChromeOptions options = new ChromeOptions();
//		    options.addArguments("--headless");
		    WebDriverManager.chromedriver().setup();
		    obj = new ChromeDriver();
		    log.info("Chrome Object is Created  " + obj);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
//	    	FirefoxOptions options = new FirefoxOptions();
//		    options.addArguments("--headless");
			WebDriverManager.firefoxdriver().setup();
			obj = new FirefoxDriver();
			log.info("FireFoxDriver Object is Created  " + obj);
		}
		else
		{
			throw new IllegalArgumentException("Unsupported browser specified in properties file: " + browser);
		}
		obj.manage().window().maximize();
		obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.info("Browser Got Opened");
		String url = prop.getProperty("Url").trim();
		obj.get(url);
		log.info("url Called  " + url);
		log.info("Tear Up is Done");
	}
	@AfterTest(enabled=true) 
	public void CloseBrowser()
	{
		log.info("Closing Browser Method");
		try
		{
		obj.close();
		log.info("Application Closed");
		log.info("===================");
		}
		catch(Exception e)
		{
			log.error("Browser not closed! Exception:" + e.getMessage());
		}
	}

}
