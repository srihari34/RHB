package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utilities.HelperClass;
import utilities.ReadExcelData;

public class DocSegmentsPage extends HelperClass{

	private static Logger log = LogManager.getLogger(DocSegmentsPage.class);

	WebDriver obj;

	public DocSegmentsPage(WebDriver driver) {
		super(driver);
		this.obj = driver;
		PageFactory.initElements(obj, this);

	}
	
	@FindBy(xpath = "//span[text()='Document Segments']")
	WebElement DocumentSegment;
	
	@FindBy(xpath = "//button[@title='Add New DocSegment']")
	WebElement addnewsegment;
	
	@FindBy(name = "name")
	WebElement docsegmentname;
	
	@FindBy(xpath = "//mat-select[@name='customQuery']//div[1]")
	WebElement customquerydropdown;
	
	@FindBy(xpath = "//span[text()='Notice_MCA']")
	WebElement customquery;
	
	@FindBy(xpath = "//mat-select[@name='vaultDatabase']")
	WebElement vaultdropdown;
	
	@FindBy(xpath = "//span[text()='ntc_mca']")
	WebElement valutserver;
	
	@FindBy(xpath = "//th[normalize-space(text())='Groups']/preceding-sibling::th[1]//input[@type='checkbox']")
	WebElement GroupsCheckBox;
	
	@FindBy(xpath = "//a[@href='#searchOptions']")
	WebElement ConfigureSearchOptionLink;
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[2]/ng-component[1]/section[2]/form[1]/fieldset[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/mat-radio-group[1]/mat-radio-button[1]/label[1]/span[1]/span[1]")
	WebElement bin_number;
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[2]/ng-component[1]/section[2]/form[1]/fieldset[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[7]/mat-radio-group[1]/mat-radio-button[1]/label[1]/span[1]/span[1]")
	WebElement id_number;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement Save_Button;
	
	@FindBy(xpath = "//tr[td[text()='Hello']]//i[@title='View']")
	WebElement View_Doc_Seg;
	
	@FindBy(xpath = "//tr[td[text()='Hello']]//i[@title='Edit']")
	WebElement edit_Doc_Seg;
	
	@FindBy(xpath = "//tr[td[text()='Hello']]//i[@title='Delete']")
	WebElement delete_Doc_Seg;
	
	@FindBy(css = ".fas.fa-times")
	WebElement closeIconRole;
	
	@FindBy(css = ".far.fa-saves")
	WebElement saveIconGroupRoleUser;
	
	@FindBy(xpath = "//div[@id='jBox4']//div[contains(@class, 'jBox-Confirm-button-submit') and text()='Yes']")
	WebElement docsegDeleteYes;
	
	
	
	@Step("Adding the Document Segment by reading the data from Excel")
	public boolean addDocSegment() {
		try
		{
			log.info("Add New Document Segement");
			String userpath = System.getProperty("user.dir");
			ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","DocSegment");
			String docsegname = red.getCellData(2, 0);
			String custque = red.getCellData(2, 1);
			String archivedb = red.getCellData(2, 2);
			String isarchiveid = red.getCellData(2, 3);
			String isaccnumber = red.getCellData(2, 4);
			WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(DocumentSegment));
			if(!safeClick(DocumentSegment, "Documents Segment Module")) return false;
			if(!safeClick(addnewsegment, "Add New Segement")) return false;
			By spinnerLocator = By.xpath("//div[@id='ajax-loading' and contains(@style, 'display: block')]");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
			wait.until(ExpectedConditions.visibilityOf(docsegmentname)).sendKeys(docsegname);
			if(!safeClick(customquerydropdown, "Custom Query Drop Down")) return false;
			String custquedynamic = String.format("//span[text()='%s']", custque);
			WebElement custqueweb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(custquedynamic)));
			if(!safeClick(custqueweb, "Custom Query Select")) return false;
			if(!safeClick(vaultdropdown, "Vault Drop Down")) return false;
			String archivedbdynamic = String.format("//span[text()='ntc_mca']", archivedb);
			WebElement archivedbweb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(archivedbdynamic)));
			if(!safeClick(archivedbweb, "Vault Server")) return false;
			if(!safeJSClick(GroupsCheckBox, "Groups Checkbox")) return false;
			if(!safeClick(ConfigureSearchOptionLink, "Configue Link Tab")) return false;
			String archiveiddynamic = String.format("//tr[td[normalize-space(text())='%s']]//td[.//mat-radio-group[@role='radiogroup']][1]", isarchiveid);
			WebElement archiveidweb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(archiveiddynamic)));
			if(!safeClick(archiveidweb, "Archive Id")) return false;
			String accountnumrefdynamic = String.format("//tr[td[normalize-space(text())='%s']]//td[.//mat-radio-group[@role='radiogroup']][2]", isaccnumber);
			WebElement accountnumrefweb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(accountnumrefdynamic)));
			if(!safeClick(accountnumrefweb, "Account Number")) return false;
			if(!safeClick(Save_Button, "Save Button")) return false;
			log.info("New Document Segement Added Sucessfully");
			return true;
		}
		catch(Exception e)
		{
			log.error("Add New Document Segement Failed" +  e);
			return false;
		}
	}
	@Step("View the Document Segement which was recently added")
	public boolean viewDocSegement() {
		
		log.info("View Doc Segment");
		try {
			WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
			String userpath = System.getProperty("user.dir");
			ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","DocSegment");
			String docsegname = red.getCellData(2, 0);
			String custquedynamic = String.format("//tr[td[text()='%s']]//i[@title='View']", docsegname);
			WebElement custqueweb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(custquedynamic)));
			 if(!safeClick(custqueweb,"View Icon")) return false;
			 if(!safeClick(closeIconRole,"Close View Icon")) return false;
			 return true;
		     }
		     catch(Exception e)
		     {
			  log.error("View Document Segement Failed" + e);
		      return false;
		}
		
	}
	@Step("Edit the Document Segement which was recently added")
	public boolean editDocSegement() {
		
		log.info("Edit Doc Segment");
		try {
			WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
			String userpath = System.getProperty("user.dir");
			ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","DocSegment");
			String docsegname = red.getCellData(2, 0);
			String custquedynamic = String.format("//tr[td[text()='%s']]//i[@title='Edit']", docsegname);
			WebElement custqueweb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(custquedynamic)));
			 if(!safeClick(custqueweb,"Edit Icon")) return false;
			 if(!safeClick(saveIconGroupRoleUser,"Save Icon")) return false;
			return true;
		}
		catch(Exception e)
		{
			log.error("Edit Document Segement Failed" + e);
		return false;
		}
	}
	@Step("Delete the Document Segement which was recently added")
	public boolean deleteDocSegement() {
		
		log.info("Delete Doc Segment");
		try {
			WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
			String userpath = System.getProperty("user.dir");
			ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","DocSegment");
			String docsegname = red.getCellData(2, 0);
			String custquedynamic = String.format("//tr[td[text()='%s']]//i[@title='Delete']", docsegname);
			WebElement custqueweb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(custquedynamic)));
			 if(!safeClick(custqueweb,"Delete Icon")) return false;
			 if(!safeClick(docsegDeleteYes,"Delete Icon")) return false;
			return true;
		}
		catch(Exception e)
		{
			log.error("Delete Document Segement Failed" + e);
		return false;
		}
	}
}
