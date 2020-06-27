package com.crmfaa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmfaa.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory--OR----
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement login;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	//initializing the page object:
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String vlaidatePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
		

	}

}
