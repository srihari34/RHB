package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.AccessPermissionsPage;
import pages.LoginPage;

public class AccessPermissions extends BaseClass {

	private static Logger log = LogManager.getLogger(AccessPermissions.class);
	LoginPage loginobj;

	AccessPermissionsPage accessobj;

	@BeforeClass
	public void verifyAccessPermissionsSetup() throws IOException {
		loginobj = new LoginPage(obj); 
		log.info("Access Permissions link Click");
		accessobj = new AccessPermissionsPage(obj);
	}

	@Test(priority = 1,enabled=true)
	public void verifyAddGroup() throws InterruptedException {
		log.info("This is Add Group Method");

		boolean isGroupAdded = accessobj.addGroup();
		Assert.assertTrue(isGroupAdded, "Group was not added successfully!");
	}
	@Test(priority = 2,enabled=true, dependsOnMethods= {"verifyAddGroup"})
	public void verifyViewGroup() throws InterruptedException {
		log.info("This is View Group Method");

		boolean isGroupviewed = accessobj.viewGroup();
		Assert.assertTrue(isGroupviewed, "Group was not Viewed successfully!");
	}
	@Test(priority = 3,enabled=true, dependsOnMethods= {"verifyAddGroup"})
	public void verifyEditGroup() throws InterruptedException {
		log.info("This is Edit Group Method");

		boolean isGroupedited = accessobj.editGroup();
		Assert.assertTrue(isGroupedited, "Group was not edited successfully!");
	}
	
	@Test(priority = 4,enabled=true, dependsOnMethods= {"verifyAddGroup"})
	public void verifyDeleteGroup() throws InterruptedException {
		log.info("This is Delete Group Method");

		boolean isGroupdeleted = accessobj.deleteGroup();
		Assert.assertTrue(isGroupdeleted, "Group was not Deleted successfully!");
	}

	@Test(priority = 5,enabled=true)
	public void verifyAddRole() throws InterruptedException {
		log.info("This is Add Role Method");

		boolean isRoleAdded = accessobj.addRole();
		Assert.assertTrue(isRoleAdded, "Role was not added successfully!");
	}
	@Test(priority = 6,enabled=true, dependsOnMethods= {"verifyAddRole"})
	public void verifyViewRole() throws InterruptedException {
		log.info("This is View Role Method");

		boolean isRoleviewed = accessobj.viewRole();
		Assert.assertTrue(isRoleviewed, "Role was not Viewed successfully!");
	}
	@Test(priority = 7,enabled=true, dependsOnMethods= {"verifyAddRole"})
	public void verifyEditRole() throws InterruptedException {
		log.info("This is Edit Role Method");

		boolean isRoleedited = accessobj.editRole();
		Assert.assertTrue(isRoleedited, "Role was not Edited successfully!");
	}
	
	@Test(priority = 8, enabled=true,dependsOnMethods= {"verifyAddRole"})
	public void verifyDeleteRole() throws InterruptedException {
		log.info("This is Delete Role Method");

		boolean isRoledeleted = accessobj.deleteRole();
		Assert.assertTrue(isRoledeleted, "Role was not Delete successfully!");
	}

	@Test(priority = 9)
	public void verifyAddUser() throws InterruptedException {
		log.info("This is an Add User Method");

		boolean isuserAdded = accessobj.addUser();
		Assert.assertTrue(isuserAdded, "User was not added successfully!");
	}
	
	@Test(priority = 10, dependsOnMethods= {"verifyAddUser"})
	public void verifyViewUser() throws InterruptedException {
		log.info("This is User View  Method");

		boolean isUserviewed = accessobj.viewUser();
		Assert.assertTrue(isUserviewed, "User was not Viewed successfully!");
	}
	@Test(priority = 11, dependsOnMethods= {"verifyAddUser"})
	public void verifyEditUser() throws InterruptedException {
		log.info("This is User edit  Method");

		boolean isUseredited = accessobj.editUser();
		Assert.assertTrue(isUseredited, "User was not Edited successfully!");
	}
	@Test(priority = 12, dependsOnMethods= {"verifyAddUser"})
	public void verifyDeleteUser() throws InterruptedException {
		log.info("This is User Delete  Method");

		boolean isUserdeleted = accessobj.deleteUser();
		Assert.assertTrue(isUserdeleted, "User was not Edited successfully!");
	}
	

}
