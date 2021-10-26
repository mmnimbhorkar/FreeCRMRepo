package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage LoginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialisation();
		Thread.sleep(3000);
		LoginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String title = LoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void loginTest() throws IOException, InterruptedException {
		homePage = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(7000);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.close();
	}




}
