package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[@class='user-display']")
	WebElement user;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement deals;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasks;
	
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage displayContacts() throws IOException {
		contacts.click();
		driver.findElement(By.xpath("//html//body")).click();
		return new ContactsPage();
	}
	
	public DealsPage displayDeals() throws IOException {
		deals.click();
		return new DealsPage();
	}
	
	public TaskPage displayTaskPage() throws IOException {
		tasks.click();
		return new TaskPage();
		
	}
	
}
