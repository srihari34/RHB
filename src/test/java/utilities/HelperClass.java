package utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

	WebDriver obj;

	private static Logger log = LogManager.getLogger(HelperClass.class);

	public HelperClass(WebDriver driver) {
		this.obj = driver;
	}

	public boolean safeClick(WebElement element, String elementname) {
		By spinnerLocator = By.xpath("//div[@id='ajax-loading' and contains(@style, 'display: block')]");
	    try {
	        WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(5));
	        wait.pollingEvery(Duration.ofMillis(500))
	            .ignoring(NoSuchElementException.class)
	            .until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
			((JavascriptExecutor) obj).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			log.info(elementname + " Clicked");
			return true;

		} catch (Exception e) {
			  log.error("Failed to click on " + elementname + ": " + e.getMessage());
		        return false;
		}
	}
	public boolean safeJSClick(WebElement element, String elementName) {
	    try {
	        ((JavascriptExecutor) obj).executeScript("arguments[0].click();", element);
	        log.info(elementName + " JS Clicked");
	        return true;
	    } catch (Exception e) {
	        log.error("Failed to JS click " + elementName + ": " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean isElementVisible(WebElement element, String elementName, int timeout) {
	    try {
	        WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(timeout));
	        wait.until(ExpectedConditions.visibilityOf(element));
	        log.info(elementName + " is visible");
	        return true;
	    } catch (Exception e) {
//	        log.warn(elementName + " is NOT visible", e);
	        return false;
	    }
	}
	
//	public boolean isSendKey(WebElement sendelement, String value) {
//		By spinnerLocator = By.xpath("//div[@id='ajax-loading' and contains(@style, 'display: block')]");
//	    try {
//	        WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(5));
//	        wait.pollingEvery(Duration.ofMillis(400))
//	            .ignoring(NoSuchElementException.class)
//	            .until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
//			((JavascriptExecutor) obj).executeScript("arguments[0].scrollIntoView({block: 'center'});", sendelement);
//			wait.until(ExpectedConditions.visibilityOf(sendelement));
//			wait.until(ExpectedConditions.elementToBeClickable(sendelement));
//			sendelement.sendKeys(value);
//			log.info(sendelement + " is Ready To Take the input");
//			return true;
//
//		} catch (Exception e) {
//			  log.error("Failed to take input " + sendelement + ": " + e.getMessage());
//		        return false;
//		}
//	}


}
