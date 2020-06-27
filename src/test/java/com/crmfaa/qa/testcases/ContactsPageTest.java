package com.crmfaa.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmfaa.qa.base.TestBase;
import com.crmfaa.qa.pages.ContactsPage;
import com.crmfaa.qa.pages.HomePage;
import com.crmfaa.qa.pages.LoginPage;
import com.crmfaa.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {		
		   super();
		}
	//Here defining all the pre-conditions.
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));//it will login into the application.
		contactsPage = homePage.clickOnContactlink();//it will click on the Contacts link.
	}
	
	//Just verifying the 'Create New Contact' label is present or not.
	@Test(priority=1)
	public void VerifyContactPageLavelTest() {
		Assert.assertTrue(contactsPage.verifyContactPageLable());
	}
	
	//Just verifying the 'New' button click of Contact page.
	@Test(priority=2)
	public void verifyNewButtonClickTest() {
		contactsPage.verifyNewButtonClick();
		driver.navigate().refresh();
		
	}
	
	@DataProvider
	public Object[][] getCRTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;	
	}
	
	//Verifying the 'New' button click and entering the first and last name into contact form. Used refresh because page have bug,its required 
	//to refresh the page to display the page fields.
	@Test(priority=3, dataProvider="getCRTestData")
	public void verifyContactCreationTest(String firstname, String lastname) {
		contactsPage.verifyNewButtonClick();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		//contactsPage.verifyCreateContactNew("JaiShiv", "Tiwari");
		//contactsPage.verifyCreateContactNew(firstname, lastname);
	}	
	
	@AfterMethod
	public void LastMethod() {
		driver.close();
		
	}
	
}
















