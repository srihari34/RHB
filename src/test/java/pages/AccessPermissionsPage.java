package pages;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utilities.HelperClass;
import utilities.ReadExcelData;

public class AccessPermissionsPage extends HelperClass {

	private static Logger log = LogManager.getLogger(AccessPermissionsPage.class);

	WebDriver obj;

	public AccessPermissionsPage(WebDriver driver) {
		super(driver);
		this.obj = driver;
		PageFactory.initElements(obj, this);

	}
	

	@FindBy(xpath = "//span[text()='Access & Permissions']")
	private WebElement AccessPermissions;

	@FindBy(xpath = "//span[text()='Groups']")
	WebElement Groups;

	@FindBy(xpath = "//span[text()='Roles']")
	WebElement Roles;

	@FindBy(xpath = "//span[text()='Users']")
	WebElement Users;

	@FindBy(xpath = "//div[@id='ajax-loading' and contains(@style, 'display: block')]")
	WebElement spinner;

	@FindBy(xpath = "//button[@title=\"Add New Group\"]")
	WebElement add_new_group;

	@FindBy(xpath = "//button[@title='Add New Role']")
	WebElement add_new_role;

	@FindBy(name = "name")
	WebElement name;

	@FindBy(xpath = "//input[@name='description']")
	WebElement description;

	@FindBy(xpath = "//mat-checkbox[@class =  'mat-checkbox mat-accent'][1]")
	WebElement AllModules;

	@FindBy(id = "mat-checkbox-1")
	WebElement Module;

	@FindBy(id = "mat-checkbox-2")
	WebElement Accesspermisionmodule;

	@FindBy(id = "mat-checkbox-3")
	WebElement Archiveviewermodule;

	@FindBy(id = "mat-checkbox-4")
	WebElement cofigurationmodule;

	@FindBy(id = "mat-checkbox-5")
	WebElement datasetupmodule;

	@FindBy(id = "mat-checkbox-6")
	WebElement reportsmodule;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement submit;

	@FindBy(xpath = "//mat-select[@name='group']")
	WebElement selectgroupdropdown;

	@FindBy(xpath = "//span[text()=' Group ']")
	WebElement selectgroupname;

	@FindBy(xpath = "//mat-panel-title[text()=' Access Permissions ']")
	WebElement Access_Permission_DropDown;

	@FindBy(xpath = "//mat-panel-title[text()=' Archive Viewer ']")
	WebElement Archive_Viewer_DropDown;

	@FindBy(xpath = "//mat-panel-title[text()=' Configuration ']")
	WebElement Configuration_DropDown;

	@FindBy(xpath = "//mat-panel-title[text()=' Data Setup ']")
	WebElement Data_Setup_DropDown;

	@FindBy(xpath = "//mat-panel-title[text()=' Reports ']")
	WebElement Reports_DropDown;

	@FindBy(xpath = "//td[text()='Groups']/following-sibling::td[@class='ng-star-inserted'][1]")
	WebElement GroupAddPermission;
//	@FindBy(xpath="//td[text()='Groups']/following-sibling::td[@class='ng-star-inserted'][2]")
//	WebElement GroupEditPermission;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement SaveRole;

	@FindBy(name = "loginId")
	WebElement LoginId;

	@FindBy(name = "firstName")
	WebElement FirstName;

	@FindBy(name = "lastName")
	WebElement LastName;

	@FindBy(name = "emailId")
	WebElement EmailId;

	@FindBy(name = "department")
	WebElement Department;

	@FindBy(name = "phoneNumber")
	WebElement PhoneNuumber;

	@FindBy(xpath = "//span[text()='--Select Role--']")
	WebElement SelectRoleUser;

	@FindBy(xpath = "//span[text()=' Admin ']")
	WebElement SelectGroupUser;

	@FindBy(xpath = "//span[text()='Yes']")
	WebElement ActiveUser;

	@FindBy(xpath = "//input[@name = 'isActive']")
	WebElement Activeateuser;

	@FindBy(xpath = "//span[text()='Users']")
	WebElement UserSubModule;

	@FindBy(xpath = "//span[text()=' Admin ']")
	WebElement RoleSelectedUser;

	@FindBy(xpath = "//button[text()=' New User']")
	WebElement NewUserClick;

	@FindBy(id = "ajax-loading")
	WebElement ajarloadrole;
	
	@FindBy(xpath = "//tr[td[@title='Groupsss']]//i[@title='View']")
	WebElement view_group;
	
	@FindBy(xpath = "//tr[td[@title='Rolesss']]//i[@title='View']")
	WebElement view_role;
	
	@FindBy(xpath = "//tr[td[text()='Usersss']]//i[@title='View']")
	WebElement view_user;
	
	@FindBy(xpath = "//tr[td[@title='Groupsss']]//i[@title='Edit']")
	WebElement edit_group;
	
	@FindBy(xpath = "//tr[td[@title='Rolesss']]//i[@title='Edit']")
	WebElement edit_role;
	
	@FindBy(xpath = "//tr[td[text()='Usersss']]//i[@title='Edit']")
	WebElement edit_user;
	
	@FindBy(xpath = "//tr[td[@title='Groupsss']]//i[@title='Delete']")
	WebElement delete_group;
	
	@FindBy(xpath = "//tr[td[@title='Rolesss']]//i[@title='Delete']")
	WebElement delete_role;
	
	@FindBy(xpath = "//tr[td[text()='Usersss']]//i[@title='Delete']")
	WebElement delete_user;
	
	@FindBy(xpath = "//div[text()='Yes']")
	WebElement yestodelete;
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement closeView;
	
	@FindBy(css = ".fas.fa-times")
	WebElement closeIconRole;
	
	@FindBy(css = ".fa.fa-times")
	WebElement closeIconUser;
	
	@FindBy(css = ".far.fa-save")
	WebElement saveIconGroupRoleUser;
	
	@FindBy(xpath = "//div[@id='jBox2']//div[contains(@class, 'jBox-Confirm-button-submit') and text()='Yes']")
	WebElement roleDeleteYes;
	
	@FindBy(xpath = "//div[@id='jBox3']//div[contains(@class, 'jBox-Confirm-button-submit') and text()='Yes']")
	WebElement UserDeleteYes;

    @Step("Adding the Group by reading the data from Excel")
	public boolean addGroup() throws InterruptedException {
		
		
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String egroupname = red.getCellData(2, 0);
		String egroupdescription = red.getCellData(2, 1);
		JavascriptExecutor js = (JavascriptExecutor) obj;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(spinner));
		if(!safeClick(AccessPermissions, "Access Permissions Module")) return false;
		if(!safeClick(Groups, "Sub Module Group is clicked")) return false;
		if(!safeClick(add_new_group, "New Group Button is clicked")) return false;
		wait.until(ExpectedConditions.visibilityOf(name)).clear();
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys(egroupname);
		wait.until(ExpectedConditions.visibilityOf(description)).sendKeys(egroupdescription);
		if(!safeClick(AllModules, "All Modules is clicked")) return false;
		js.executeScript("arguments[0].scrollIntoView(true);", submit);
		WebElement SaveGroup = wait.until(ExpectedConditions.elementToBeClickable(submit));
		js.executeScript("arguments[0].click();", SaveGroup);
		log.info("Group Created Successfully");
		return true;
		}
		catch (Exception e) {
		log.error("JS click failed: " + e.getMessage());
		return false;
		}

	}
    @Step("View the Group which was recently added")
	public boolean viewGroup()
	{
		log.info("View Group method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String egroupname = red.getCellData(2, 0);
		JavascriptExecutor js = (JavascriptExecutor) obj;
		String dynamicXPath = String.format("//tr[td[@title='%s']]//i[@title='View']", egroupname);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement viewGroupIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
		if(!safeClick(viewGroupIcon, "View Group")) return false;
		js.executeScript("arguments[0].scrollIntoView(true);", closeView);
		if(!safeClick(closeView, "Close Group")) return false;
		log.info("View Group Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("View Group Failed", e.getMessage());
			return false;
		}
		
	}
    @Step("Edit the Group which was recently added")
	public boolean editGroup()
	{
		log.info("Edit Group method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String egroupname = red.getCellData(2, 0);
		JavascriptExecutor js = (JavascriptExecutor) obj;
		String dynamicXPath = String.format("//tr[td[@title='%s']]//i[@title='Edit']", egroupname);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement editGroupIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
		if(!safeClick(editGroupIcon, "Edit Group")) return false;
		wait.until(ExpectedConditions.visibilityOf(name)).clear();
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys(egroupname);
		js.executeScript("arguments[0].scrollIntoView(true);", saveIconGroupRoleUser);
		if(!safeClick(saveIconGroupRoleUser, "Save Group")) return false;
		log.info("Edit Group Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("Edit Group Failed", e.getMessage());
			return false;
		}
		
	}
    @Step("Delelte the Group which was recently added")
	public boolean deleteGroup()
	{
		log.info("Delete Group method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String egroupname = red.getCellData(2, 0);
		String dynamicXPath = String.format("//tr[td[@title='%s']]//i[@title='Delete']", egroupname);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement deleteGroupIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));	
		if(!safeClick(deleteGroupIcon, "Delete Group")) return false;
		if(!safeClick(yestodelete,"Delete Yes")) return false;
		log.info("Delete Group Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("Delete Group Failed", e.getMessage());
			return false;
		}
		
	}
    @Step("Adding the Role by reading the data from Excel")
	public boolean addRole() throws InterruptedException {
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String erolename = red.getCellData(6, 0);
		String egroupname = red.getCellData(6, 1);
		String eroledescription = red.getCellData(6, 2);
		JavascriptExecutor js = (JavascriptExecutor) obj;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.invisibilityOf(spinner));
		if(!safeClick(Roles, "Roles Module")) return false;
		if(!safeClick(add_new_role, "Add New Role")) return false;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", name);
		wait.until(ExpectedConditions.visibilityOf(name)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys(erolename);
		if(!safeClick(selectgroupdropdown, "Group Down Selected ")) return false;
	//	safeClick(selectgroupname, "Group Name  Selected ");
		String dynamicXPath = String.format("//mat-option//span[normalize-space(text())='%s']", egroupname);
		WebElement dynamicOption = wait.until(
			    ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
		if(!safeClick(dynamicOption, "Select Group Name")) return false;
			    
		wait.until(ExpectedConditions.visibilityOf(description)).sendKeys(eroledescription);
		if(!safeClick(Access_Permission_DropDown, "Select Permissions Access Permissions")) return false;
		js.executeScript("arguments[0].scrollIntoView(true);", GroupAddPermission);
		if(!safeClick(GroupAddPermission, "Group Add Permissions in Access Permissions for Role")) return false;
		if(!safeClick(Access_Permission_DropDown, "Select Permissions Access Permissions")) return false;
		js.executeScript("arguments[0].scrollIntoView(true);", SaveRole);
		if(!safeJSClick(SaveRole , "Role Saved")) return false;
			log.info("Roles Created Successfully");
			return true;
		} catch (Exception e) {
			log.error("JS click failed: " + e.getMessage());
			return false;
		}
	}
	@Step("View the Role which was recently added")
	public boolean viewRole()
	{
		log.info("View Role method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String erolename = red.getCellData(6, 0);
		String dynamicXPath = String.format("//tr[td[@title='%s']]//i[@title='View']", erolename);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement viewRoleIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));	
		if(!safeClick(viewRoleIcon, "View Role")) return false;
		if(!safeClick(closeIconRole, "Close Role")) return false;
		log.info("View Role Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("View Role Failed", e.getMessage());
			return false;
		}
		
	}
	@Step("Edit the Role which was recently added")
	public boolean editRole()
	{
		log.info("Edit Role method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String erolename = red.getCellData(6, 0);
		JavascriptExecutor js = (JavascriptExecutor) obj;
		String dynamicXPath = String.format("//tr[td[@title='%s']]//i[@title='Edit']", erolename);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement editRoleIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));	
		if(!safeClick(editRoleIcon, "Edit Role")) return false;
		wait.until(ExpectedConditions.visibilityOf(name));
		wait.until(ExpectedConditions.elementToBeClickable(name)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys(erolename);
		js.executeScript("arguments[0].scrollIntoView(true);", saveIconGroupRoleUser);
		if(!safeClick(saveIconGroupRoleUser, "Save Role")) return false;
		log.info("Edit Role Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("Edit Role Failed", e.getMessage());
			return false;
		}
		
	}
	@Step("Delete the Role which was recently added")
	public boolean deleteRole()
	{
		log.info("Delete Role method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String erolename = red.getCellData(6, 0);
		String dynamicXPath = String.format("//tr[td[@title='%s']]//i[@title='Delete']", erolename);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement deleteRoleIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));	
		if(!safeClick(deleteRoleIcon, "Delete Role Icon ")) return false;
		if(!safeClick(roleDeleteYes, "Delete Yes")) return false;
		log.info("Delete Role Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("Delete Role Failed", e.getMessage());
			return false;
		}
		
	}
	@Step("Adding the User by reading the data from Excel")
	public boolean addUser() throws InterruptedException {
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String eloginid = red.getCellData(10, 0);
		String efirstname = red.getCellData(10, 1);
		String elastname = red.getCellData(10, 2);
		String eemailid = red.getCellData(10, 3);
		String edepartment = red.getCellData(10, 4);
		String ephone = red.getCellData(10, 5);
		JavascriptExecutor js = (JavascriptExecutor) obj;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		js.executeScript("arguments[0].click();", UserSubModule);
		// safeClick(UserSubModule ,"User Module to be selected ");
		WebElement NewUserClicks = wait.until(ExpectedConditions.elementToBeClickable(NewUserClick));
		js.executeScript("arguments[0].click();", NewUserClicks);
	//	wait.until(ExpectedConditions.invisibilityOf(spinner));
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("loginId"))); // ensures element exists
		// Now wait until it's visible and interactable
		WebElement loginField = wait.until(ExpectedConditions.visibilityOf(LoginId));
		wait.until(ExpectedConditions.elementToBeClickable(loginField));
		// Optional: handle Angular animation delay (if still unstable)
		wait.until(driver -> loginField.isDisplayed() && loginField.isEnabled());
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", LoginId);
		wait.until(ExpectedConditions.elementToBeClickable(LoginId)).sendKeys(eloginid);
		wait.until(ExpectedConditions.visibilityOf(FirstName)).sendKeys(efirstname);
		wait.until(ExpectedConditions.visibilityOf(LastName)).sendKeys(elastname);
		wait.until(ExpectedConditions.visibilityOf(EmailId)).sendKeys(eemailid);
		wait.until(ExpectedConditions.visibilityOf(Department)).sendKeys(edepartment);
		js.executeScript("arguments[0].scrollIntoView(true);", PhoneNuumber);
		wait.until(ExpectedConditions.visibilityOf(PhoneNuumber)).sendKeys(ephone);
		safeClick(SelectRoleUser, "Select Role User  Radio Button ");
		safeClick(SelectGroupUser, "Selected Role User  Radio Button ");
		js.executeScript("arguments[0].scrollIntoView(true);", Activeateuser);
		((JavascriptExecutor) obj).executeScript("arguments[0].scrollIntoView(true);", Activeateuser);
		if (!safeJSClick(Activeateuser, "Active User Radio Button")) return false;
		if (!safeClick(submit, "Submit Button")) return false;
			log.info("User Created Successfully");
			return true;
		} catch (Exception e) {
			log.error("JS click failed: " + e.getMessage());
			return false;
		}
	}
	@Step("View the User which was recently added")
	public boolean viewUser()
	{
		log.info("View User method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String eusername = red.getCellData(10, 0);
		String dynamicXPath = String.format("//tr[td[normalize-space(text())='%s']]//i[@title='View']", eusername);
	    WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement viewUserIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
		if(!safeClick(viewUserIcon, "View User")) return false;
		if(!safeClick(closeIconUser, "Close User")) return false;
		log.info("View User Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("View User Failed",e.getMessage());
			return false;
		}
		
	}
	@Step("Edit the User which was recently added")
	public boolean editUser()
	{
		log.info("Edit User method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String eusername = red.getCellData(10, 0);
		JavascriptExecutor js = (JavascriptExecutor) obj;
		String dynamicXPath = String.format("//tr[td[normalize-space(text())='%s']]//i[@title='Edit']", eusername);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement editUserIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
		if(!safeClick(editUserIcon, "Edit User")) return false;	
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", LoginId);
		wait.until(ExpectedConditions.elementToBeClickable(LoginId));
		wait.until(ExpectedConditions.visibilityOf(LoginId)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(LoginId)).sendKeys(eusername);
		js.executeScript("arguments[0].scrollIntoView(true);", saveIconGroupRoleUser);
		if(!safeClick(saveIconGroupRoleUser, "Save User")) return false;
		log.info("Edit User Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("Edit User Failed", e.getMessage());
			return false;
		}
		
	}
	@Step("Delete the User which was recently added")
	public boolean deleteUser()
	{
		log.info("Delete User method entered");
		try {
		String userpath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","AccessPermission");
		String eusername = red.getCellData(10, 0);
		String dynamicXPath = String.format("//tr[td[normalize-space(text())='%s']]//i[@title='Delete']", eusername);
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		WebElement deleteUserIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));
		if(!safeClick(deleteUserIcon, "Delete User")) return false;
		if(!safeClick(UserDeleteYes,"Delete Yes")) return false;
		log.info("Delete User Successfull");
//		if(!safeClick(AccessPermissions, "Access Permissions Module")) return false;
		return true;
		}
		catch(Exception e)
		{
			log.error("Delete User Failed", e.getMessage());
			return false;
		}
		
	}
}
