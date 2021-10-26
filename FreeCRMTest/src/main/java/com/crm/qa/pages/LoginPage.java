package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// pagefactory - object repository: in page classes, we have to find and assign all the relevant webelements of that page
	
	@FindBy(name="email")
	WebElement name;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement login;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signup;
	
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) throws IOException {
		name.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	}
	
	
}
