package com.crm.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage LoginPage;
	ContactsPage ContactsPage;
	HomePage homepage;
	String sheetname = "contacts";
	
	public ContactsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialisation();
		Thread.sleep(3000);
		LoginPage = new LoginPage();
		ContactsPage = new ContactsPage();
		homepage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.displayContacts();
	}
	
//	@Test(priority = 1)
//	public void verifyContactsPageLabel() {
//		Assert.assertTrue(ContactsPage.contactsPageLabel(), "contacts label is missing on the page");;
//	}
//	
//	@Test(priority = 2, dataProvider = "getTestDataforInsertion")
//	public void addContact(String firstname, String lastname) throws IOException {
//		ContactsPage.createContact(firstname, lastname);
//	}
	
	@Test(priority = 3)
	public void selectContactTest() throws InterruptedException {
		ContactsPage.selectContact("Mil1 Nim1");
		Thread.sleep(7000);
	}
	
	@DataProvider
	public Object[][] getTestDataforInsertion() throws InvalidFormatException, IOException {
		Object[][] data = TestUtil.getTestData("contacts");
		return data;
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
	
}
