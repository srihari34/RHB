package Page_Objects;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Helper_Class;

public class Access_Permissions_page extends Helper_Class {

	private static Logger log = LogManager.getLogger(Access_Permissions_page.class);

	WebDriver obj;

	public Access_Permissions_page(WebDriver driver) {
		super(driver);
		this.obj = driver;
		PageFactory.initElements(obj, this);

	}
	

	@FindBy(xpath = "//span[text()='Access & Permissions']")
	WebElement AccessPermissions;

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


	public boolean addgroup() throws InterruptedException {
		try {
		JavascriptExecutor js = (JavascriptExecutor) obj;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(spinner));
		if(!safeClick(AccessPermissions, "Access Permissions Module")) return false;
		if(!safeClick(Groups, "Sub Module Group is clicked")) return false;
		if(!safeClick(add_new_group, "New Group Button is clicked")) return false;
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys("Groupsss");
		wait.until(ExpectedConditions.visibilityOf(description)).sendKeys("Description for Group Creation");
		if(!safeClick(AllModules, "All Modules is clicked")) return false;
		js.executeScript("arguments[0].scrollIntoView(true);", submit);
		WebElement SaveGroup = wait.until(ExpectedConditions.elementToBeClickable(submit));
	
			js.executeScript("arguments[0].click();", SaveGroup);
			log.info("Group Created Successfully");
			return true;
		} catch (Exception e) {
			log.error("JS click failed: " + e.getMessage());
			return false;
		}

	}
	
	public boolean viewgroup()
	{
		log.info("View Group method entered");
		try {
		JavascriptExecutor js = (JavascriptExecutor) obj;
		if(!safeClick(view_group, "View Group")) return false;
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
	public boolean editgroup()
	{
		log.info("Edit Group method entered");
		try {
		JavascriptExecutor js = (JavascriptExecutor) obj;
		if(!safeClick(edit_group, "Edit Group")) return false;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(name)).clear();
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys("Groupsss");
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
	
	public boolean deletegroup()
	{
		log.info("Delete Group method entered");
		try {
		if(!safeClick(delete_group, "Delete Group")) return false;
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

	public boolean addrole() throws InterruptedException {
		try {
		JavascriptExecutor js = (JavascriptExecutor) obj;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.invisibilityOf(spinner));
		if(!safeClick(Roles, "Roles Module")) return false;
		if(!safeClick(add_new_role, "Add New Role")) return false;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", name);
		wait.until(ExpectedConditions.visibilityOf(name));
		wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys("Rolesss");
		if(!safeClick(selectgroupdropdown, "Group Down Selected ")) return false;
		safeClick(selectgroupname, "Group Name  Selected ");
		wait.until(ExpectedConditions.visibilityOf(description)).sendKeys("Description for Role Creation");
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
	
	public boolean viewrole()
	{
		log.info("View Role method entered");
		try {
		if(!safeClick(view_role, "View Role")) return false;
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

	public boolean editrole()
	{
		log.info("Edit Role method entered");
		try {
		JavascriptExecutor js = (JavascriptExecutor) obj;
		if(!safeClick(edit_role, "Edit Role")) return false;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(name));
		wait.until(ExpectedConditions.elementToBeClickable(name)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys("Rolesss");
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
	
	public boolean deleterole()
	{
		log.info("Delete Role method entered");
		try {
		if(!safeClick(delete_role, "Delete Role Icon ")) return false;
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
	
	public boolean adduser() throws InterruptedException {
		try {
		JavascriptExecutor js = (JavascriptExecutor) obj;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));
		js.executeScript("arguments[0].click();", UserSubModule);
		// safeClick(UserSubModule ,"User Module to be selected ");
		WebElement NewUserClicks = wait.until(ExpectedConditions.elementToBeClickable(NewUserClick));
		js.executeScript("arguments[0].click();", NewUserClicks);
	//	wait.until(ExpectedConditions.invisibilityOf(spinner));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", LoginId);
		wait.until(ExpectedConditions.elementToBeClickable(LoginId)).sendKeys("Usersss");
		wait.until(ExpectedConditions.visibilityOf(FirstName)).sendKeys("firstname");
		wait.until(ExpectedConditions.visibilityOf(LastName)).sendKeys("lastname");
		wait.until(ExpectedConditions.visibilityOf(EmailId)).sendKeys("Name1@gmail.com");
		wait.until(ExpectedConditions.visibilityOf(Department)).sendKeys("Testing");
		js.executeScript("arguments[0].scrollIntoView(true);", PhoneNuumber);
		wait.until(ExpectedConditions.visibilityOf(PhoneNuumber)).sendKeys("8881212888");
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
	
	public boolean viewuser()
	{
		log.info("View User method entered");
		try {
		if(!safeClick(view_user, "View User")) return false;
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
	public boolean edituser()
	{
		log.info("Edit User method entered");
		try {
		JavascriptExecutor js = (JavascriptExecutor) obj;
		if(!safeClick(edit_user, "Edit User")) return false;
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(5));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", LoginId);
		wait.until(ExpectedConditions.elementToBeClickable(LoginId)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(LoginId)).sendKeys("Usersss");
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
	public boolean deleteuser()
	{
		log.info("Delete User method entered");
		try {
		if(!safeClick(delete_user, "Delete User")) return false;
		if(!safeClick(UserDeleteYes,"Delete Yes")) return false;
		log.info("Delete User Successfull");
		return true;
		}
		catch(Exception e)
		{
			log.error("Delete User Failed", e.getMessage());
			return false;
		}
		
	}
}
