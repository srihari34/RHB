package base;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static Logger log = LogManager.getLogger(BaseClass.class);
	Properties prop = new Properties();

	public static WebDriver obj;

	@BeforeSuite
	public void launchBrowser() throws IOException {
		log.info("Application Started");
		log.info("===================");
		try(InputStream inpst = getClass().getClassLoader().getResourceAsStream("utilities/TestData.properties"))
		{
			if(inpst ==null)
			{
				throw new IOException("TestData.properties not found at utilities/Test_Data.properties");
			}
			prop.load(inpst);	
		}
		
		String browser = prop.getProperty("Browser").trim();
		if(browser.equalsIgnoreCase("chrome"))
		{
			
//          UnComment Below  to run in Headless Mode
//	    	ChromeOptions options = new ChromeOptions();
//          options.addArguments("--disable-notifications");
//          options.addArguments("--disable-popup-blocking");
//          options.addArguments("--start-maximized");
//          options.addArguments("--disable-infobars");
//          options.addArguments("--headless");
		    WebDriverManager.chromedriver().setup();
		    obj = new ChromeDriver();
		    log.info("Chrome Object is Created  " + obj);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
	    	
       //   UnComment Below  to run in Headless Mode
	      FirefoxOptions options = new FirefoxOptions();
          options.addArguments("--disable-notifications");
          options.addArguments("--disable-popup-blocking");
          options.addArguments("--start-maximized");
          options.addArguments("--disable-infobars");
          options.addArguments("--headless");
		    options.addArguments("--headless");
			WebDriverManager.firefoxdriver().setup();
			obj = new FirefoxDriver();
			log.info("FireFoxDriver Object is Created  " + obj);
		}
		else
		{
			throw new IllegalArgumentException("Unsupported browser specified in properties file: " + browser);
		}
		obj.manage().window().maximize();
		obj.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		obj.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		log.info("Browser Got Opened");
		String url = prop.getProperty("Url").trim();
		obj.get(url);
		log.info("url Called  " + url);
		log.info("Tear Up is Done");
	}
	@AfterSuite(enabled=true) 
	public void closeBrowser()
	{
		log.info("Closing Browser Method");
		try
		{
		obj.quit();
		log.info("Application Closed");
		log.info("===================");
		}
		catch(Exception e)
		{
			log.error("Browser not closed! Exception:" + e.getMessage());
		}
	}

}
