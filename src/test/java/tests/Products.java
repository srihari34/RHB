package tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Products {

	@Test
	public void addProducts()
	{
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
//		      page.navigate("http://192.168.2.27:9092/");
//		      page.locator("#LoginId").click();
//		      page.locator("#LoginId").fill("Approver");
//		      page.locator("#Password").click();
//		      page.locator("#Password").fill("User@123");
//		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Configurations ")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ProductCode").setExact(true)).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("New ProductCode")).click();
		      page.locator("#mat-select-value-5").click();
		      page.getByText("IM").click();
		      page.locator("input[name=\"code\"]").click();
		      page.locator("input[name=\"code\"]").fill("456");
		      page.locator("input[name=\"name\"]").click();
		      page.locator("input[name=\"name\"]").fill("testing");
		      page.locator("textarea[name=\"remarks\"]").click();
		      page.locator("textarea[name=\"remarks\"]").fill("Testing");
		      page.getByRole(AriaRole.BUTTON).nth(2).click();
		      page.getByText("Approver Approver").click();
		      page.getByText("Sign Out", new Page.GetByTextOptions().setExact(true)).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
	}

}
}
