package com.crmfaa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmfaa.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath= "//span[contains(text(),'Rahul Tiwari')]")
	WebElement rightuser;
	
	@FindBy(xpath= " //span[contains(text(),'Contacts')]")
	WebElement contactlink;
	
	
	public HomePage() {	
		PageFactory.initElements(driver, this);	
	}
	
	public ContactsPage clickOnContactlink() {
		contactlink.click();
		return new ContactsPage();
		
	}
	
	public boolean verifyRightUser() {
		return rightuser.isDisplayed();
		
	}


}
