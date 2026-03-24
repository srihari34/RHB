package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.DetailReport;
import utilities.HelperClass;

public class DetailReportPage extends HelperClass{
	private static Logger log = LogManager.getLogger(DetailReport.class);
	
	private WebDriver driver;
	private WebDriverWait wait;

	
	public  DetailReportPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//span[text()='Reports']")
	private WebElement reportsmodule;
	
	@FindBy(xpath="//span[text()='Configurations']")
	private WebElement configurationsmodule;
	
	@FindBy(xpath="//a[text()='Detailed Report']")
	private WebElement detailedreport;
	
	@FindBy(xpath="//span[text()='--Select Product Type--']")
	private WebElement selectproducttype;

	@FindBy(xpath="//input[@placeholder='From Date']")
	private WebElement fromdate;

	@FindBy(xpath="//input[@placeholder='To Date']")
	private WebElement todate;
	
	@FindBy(xpath="//label[text()='ID Number']")
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
	
	

	public DetailReportPage clickdetailreportmodule() {
		wait.until(ExpectedConditions.elementToBeClickable(reportsmodule));
		safeClick(reportsmodule,"module");
		return this;
	}

	public DetailReportPage clicksubmodulereport() {
		wait.until(ExpectedConditions.elementToBeClickable(detailedreport));
		safeClick(detailedreport,"submodule");
		return this;
		
	}

	public DetailReportPage selectproducttype(String producttypedata) {
		wait.until(ExpectedConditions.elementToBeClickable(selectproducttype));
		safeClick(selectproducttype,"Select ProductType");
		By producttype = By.xpath(String.format("//span[normalize-space()='%s']",producttypedata.trim()));
		WebElement producttypelement =  wait.until(ExpectedConditions.elementToBeClickable(producttype));
		safeClick(producttypelement,"Product Type");
		return this;
	}

	public DetailReportPage selectfromdateicon() {
	    Actions action = 	new Actions(driver);
	    action.moveByOffset(100, 100).click().perform();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", idNumberfield);
		wait.until(ExpectedConditions.elementToBeClickable(fromdate));
		safeClick(fromdate,"From date");
		
		
		return this;
	}

	public DetailReportPage setfromdate(String fromdatevalue) {
		
		safeClick(selectyeardropdownfrom,"Year Drop Down");
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

	public DetailReportPage selecttodateicon() {
		wait.until(ExpectedConditions.elementToBeClickable(todate));
		safeClick(todate,"To Date");
		return this;
	}
	
	public DetailReportPage settodate(String todatavalue) {
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

	public DetailReportPage submit() {
		wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
		safeClick(searchbutton,"Submit Button");
		return this;
		
	}

	public DetailReportPage csvdownload() throws IOException {
		wait.until(ExpectedConditions.elementToBeClickable(downloadCSVFile));
		safeClick(downloadCSVFile,"Csvdownload");
		return this;
		
	}

	

}
