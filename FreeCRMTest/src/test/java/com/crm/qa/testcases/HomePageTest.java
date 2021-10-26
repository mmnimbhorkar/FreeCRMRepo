package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage LoginPage;
	HomePage homepage;
	ContactsPage contactsPage;
	
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialisation();	
		Thread.sleep(3000);
		LoginPage = new LoginPage();
		LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Home Page title not matched");
	}
	
	@Test(priority = 2)
	public void ClickOnContactsTest() throws IOException, InterruptedException {
		contactsPage = homepage.displayContacts();
		Thread.sleep(7000);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
}
