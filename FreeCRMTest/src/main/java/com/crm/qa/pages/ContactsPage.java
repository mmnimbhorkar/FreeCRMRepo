package com.crm.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement Contactstitle;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement create;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement savebutton;
	
		
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactsPageLabel() {
		return Contactstitle.isDisplayed();
	}
	
	public void createContact(String fn, String ln) {
		create.click();
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);	
		savebutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void selectContact(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click(); 
	}
 
}


























