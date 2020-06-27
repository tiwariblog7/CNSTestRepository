package com.crmfaa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmfaa.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//xpath of Contacts page label.
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactlavels;
	
	//xpath of New button click.
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newButtonClick;
	
	//xpath of New Contact Page label.
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement pageLavelTest;
	
	//xpath of Name field.
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	//xpath of Last Name field.
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	//xpath of Save button.
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveButton;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactPageLable() {
		return contactlavels.isDisplayed();
	}
	
	public void verifyNewButtonClick() {
		newButtonClick.click();
	}
	
	public void verifyCreateContactNew(String FN, String LN) {
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		SaveButton.click();
	}

}














