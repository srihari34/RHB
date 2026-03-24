package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.HelperClass;

public class BatchReportPage extends HelperClass{
	
	private WebDriver driver;
	private WebDriverWait wait;

	
	public  BatchReportPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//span[text()='Notice Reports']")
	private WebElement reportsmodule;
	
	@FindBy(xpath="//span[text()='Configurations']")
	private WebElement configurationsmodule;
	
	@FindBy(xpath="//a[@href='/noticesDetailedReport']//span[text()='Detailed Report']")
	private WebElement detailedreport;
	
	@FindBy(xpath="//span[text()='--Select Application Name--']")
	private WebElement selectapplicationtype;
	
	
	@FindBy(xpath="//span[text()='--Select ProductName--']")
	private WebElement selectproductname;
	
	@FindBy(xpath="//span[text()='--Select Product Type--']")
	private WebElement  producttype ;
	
	@FindBy(xpath="//span[text()='ASB']")
	private WebElement asb;

	@FindBy(xpath="//input[@placeholder='From Date']")
	private WebElement fromdate;

	@FindBy(xpath="//input[@placeholder='To Date']")
	private WebElement todate;
	
	@FindBy(xpath="//label[text()='Product Name ']")
	private WebElement idNumberfield;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchbutton;
	
	@FindBy(className="cdk-overlay-backdrop")
	private WebElement dropdownpageesc;
	
	@FindBy(xpath="//button[@aria-label='Choose month and year']")
	private WebElement selectyeardropdownfrom;
	
	@FindBy(xpath="//button[@aria-label='Choose month and year']")
	private WebElement selectyeardropdownto;
	
	@FindBy(xpath="//button[text()='CSV']")
	private WebElement downloadCSVFile;
	
	
	public BatchReportPage clickdetailreportmodule() {
		wait.until(ExpectedConditions.elementToBeClickable(reportsmodule));
		safeClick(reportsmodule,"module");
		return this;
	}

	public BatchReportPage clicksubmodulereport() {
		wait.until(ExpectedConditions.elementToBeClickable(detailedreport));
		safeClick(detailedreport,"submodule");
		return this;
		
	}
	
	
	public BatchReportPage selectApplicationName(String appname) {
		wait.until(ExpectedConditions.elementToBeClickable(selectapplicationtype));
		safeClick(selectapplicationtype , "Application Type");
		By applicationname = By.xpath(String.format("//span[normalize-space()='%s']",appname.trim()));
		WebElement applicationnameelement =  wait.until(ExpectedConditions.elementToBeClickable(applicationname));
		safeClick(applicationnameelement,"Application Value");
		return this;
	}
	
	public BatchReportPage selectProductName(String prodtype) {
		wait.until(ExpectedConditions.elementToBeClickable(selectproductname));
		safeClick(selectproductname , "Product Name");
		By protypes = By.xpath(String.format("//span[normalize-space()='%s']",prodtype.trim()));
		WebElement protypelements =  wait.until(ExpectedConditions.elementToBeClickable(protypes));
		safeClick(protypelements,"Product Name Value");
		return this;
	}


	public BatchReportPage selectproducttype(String producttypedata) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(producttype));
		safeClick(producttype,"Select ProductType");
		By producttype = By.xpath(String.format("//span[normalize-space()='%s']",producttypedata.trim()));
		WebElement producttypelement =  wait.until(ExpectedConditions.elementToBeClickable(producttype));
		safeClick(producttypelement,"Product Type");
		Thread.sleep(2000);
		return this;
	}

	public BatchReportPage selectfromdateicon() {
//	    Actions action = 	new Actions(driver);
//	    action.moveByOffset(50, 50).click().perform();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(false);", idNumberfield);
		wait.until(ExpectedConditions.elementToBeClickable(fromdate));
		safeClick(fromdate,"From date");
		js.executeScript("window.scrollBy(0, -300);"); // scroll down 500px
		
		return this;
	}

	public BatchReportPage setfromdate(String fromdatevalue) throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(selectyeardropdownfrom));
		safeClick(selectyeardropdownfrom,"Year Drop Down");
		Thread.sleep(2000);
		String[] fromdatespilt = fromdatevalue.split("/");
		String date = fromdatespilt[0];
		String month = fromdatespilt[1];
		String year = fromdatespilt[2];
		By yearselect = By.xpath(String.format("//div[normalize-space()='%s']",year));
		WebElement selectyear =  wait.until(ExpectedConditions.elementToBeClickable(yearselect));
		safeClick(selectyear , "Year selected");
		By monthselect = By.xpath(String.format("//div[normalize-space()='%s']",month));
		WebElement selectmonth =  wait.until(ExpectedConditions.elementToBeClickable(monthselect));
		safeClick(selectmonth , "Month selected");
		By dateselect = By.xpath(String.format("//div[normalize-space()='%s']",date));
		WebElement selectdate =  wait.until(ExpectedConditions.elementToBeClickable(dateselect));
		safeClick(selectdate , "Date selected");
		return this;
	}

	public BatchReportPage selecttodateicon() {
		wait.until(ExpectedConditions.elementToBeClickable(todate));
		safeClick(todate,"To Date");
		return this;
	}
	
	public BatchReportPage settodate(String todatavalue) {
		wait.until(ExpectedConditions.elementToBeClickable(selectyeardropdownto));
		safeClick(selectyeardropdownto,"Year Drop Down");
		String[] todatespilt = todatavalue.split("/");
		String date = todatespilt[0];
		String month = todatespilt[1];
		String year = todatespilt[2];
		By yearselect = By.xpath(String.format("//div[normalize-space()='%s']",year));
		WebElement selectyear =  wait.until(ExpectedConditions.elementToBeClickable(yearselect));
		safeClick(selectyear , "Year selected");
		By monthselect = By.xpath(String.format("//div[normalize-space()='%s']",month));
		WebElement selectmonth =  wait.until(ExpectedConditions.elementToBeClickable(monthselect));
		safeClick(selectmonth , "Month selected");
		By dateselect = By.xpath(String.format("//div[normalize-space()='%s']",date));
		WebElement selectdate =  wait.until(ExpectedConditions.elementToBeClickable(dateselect));
		safeClick(selectdate , "Date selected");
		return this;
	}

	public BatchReportPage submit() {
		wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
		safeClick(searchbutton,"Submit Button");
		return this;
		
	}

	public BatchReportPage csvdownload() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(downloadCSVFile));
		safeClick(downloadCSVFile,"Csvdownload");
		return this;
		
	}

	

	
	

}
