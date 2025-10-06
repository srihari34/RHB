package test_case;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page_Objects.Access_Permissions_page;
import Page_Objects.Login_page;
import base.Base_Class;

public class Access_permissions extends Base_Class {

	private static Logger log = LogManager.getLogger(Access_permissions.class);
	Login_page loginobj;

	Access_Permissions_page accessobj;

	@BeforeClass
	public void Access_Permissions_Setup() throws IOException {
		loginobj = new Login_page(obj); 
		log.info("Access Permissions link Click");
		accessobj = new Access_Permissions_page(obj);
	}

	@Test(priority = 1)
	public void Add_Group() throws InterruptedException {
		log.info("This is Add Group Method");

		boolean isGroupAdded = accessobj.addgroup();
		Assert.assertTrue(isGroupAdded, "Group was not added successfully!");
	}
	@Test(priority = 2, dependsOnMethods= {"Add_Group"})
	public void view_Group() throws InterruptedException {
		log.info("This is View Group Method");

		boolean isGroupviewed = accessobj.viewgroup();
		Assert.assertTrue(isGroupviewed, "Group was not Viewed successfully!");
	}
	@Test(priority = 3, dependsOnMethods= {"Add_Group"})
	public void edit_Group() throws InterruptedException {
		log.info("This is Edit Group Method");

		boolean isGroupedited = accessobj.editgroup();
		Assert.assertTrue(isGroupedited, "Group was not edited successfully!");
	}
	
	@Test(priority = 4, dependsOnMethods= {"Add_Group"})
	public void delete_Group() throws InterruptedException {
		log.info("This is Delete Group Method");

		boolean isGroupdeleted = accessobj.deletegroup();
		Assert.assertTrue(isGroupdeleted, "Group was not Deleted successfully!");
	}

	@Test(priority = 5)
	public void Add_Role() throws InterruptedException {
		log.info("This is Add Role Method");

		boolean isRoleAdded = accessobj.addrole();
		Assert.assertTrue(isRoleAdded, "Role was not added successfully!");
	}
	@Test(priority = 6, dependsOnMethods= {"Add_Role"})
	public void view_Role() throws InterruptedException {
		log.info("This is View Role Method");

		boolean isRoleviewed = accessobj.viewrole();
		Assert.assertTrue(isRoleviewed, "Role was not Viewed successfully!");
	}
	@Test(priority = 7, dependsOnMethods= {"view_Role"})
	public void edit_Role() throws InterruptedException {
		log.info("This is Edit Role Method");

		boolean isRoleedited = accessobj.editrole();
		Assert.assertTrue(isRoleedited, "Role was not Edited successfully!");
	}
	
	@Test(priority = 8, dependsOnMethods= {"edit_Role"})
	public void delete_Role() throws InterruptedException {
		log.info("This is Delete Role Method");

		boolean isRoledeleted = accessobj.deleterole();
		Assert.assertTrue(isRoledeleted, "Role was not Delete successfully!");
	}

	@Test(priority = 9)
	public void Add_User() throws InterruptedException {
		log.info("This is an Add User Method");

		boolean isuserAdded = accessobj.adduser();
		Assert.assertTrue(isuserAdded, "User was not added successfully!");
	}
	
	@Test(priority = 10, dependsOnMethods= {"Add_User"})
	public void view_User() throws InterruptedException {
		log.info("This is User View  Method");

		boolean isUserviewed = accessobj.viewuser();
		Assert.assertTrue(isUserviewed, "User was not Viewed successfully!");
	}
	@Test(priority = 11, dependsOnMethods= {"view_User"})
	public void edit_User() throws InterruptedException {
		log.info("This is User edit  Method");

		boolean isUseredited = accessobj.edituser();
		Assert.assertTrue(isUseredited, "User was not Edited successfully!");
	}
	@Test(priority = 12, dependsOnMethods= {"edit_User"})
	public void delete_User() throws InterruptedException {
		log.info("This is User Delete  Method");

		boolean isUserdeleted = accessobj.deleteuser();
		Assert.assertTrue(isUserdeleted, "User was not Edited successfully!");
	}
	

}
