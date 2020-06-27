package com.crmfaa.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmfaa.qa.base.TestBase;
import com.crmfaa.qa.pages.HomePage;
import com.crmfaa.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {		
	   super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyCorrectUserName() {
		Assert.assertTrue( homePage.verifyRightUser());//pass this for making pass this test case homePage.verifyRightUser().
	}
	
	@Test(priority=2)
	public void verifyContactClick() {		
		homePage.clickOnContactlink();		
	}
	
	
	@AfterMethod
	public void Done() {
		driver.close();
				
	}	

}
