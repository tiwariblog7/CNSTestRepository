package com.crmfaa.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmfaa.qa.base.TestBase;
import com.crmfaa.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
		
	public LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void SetUp() 
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.vlaidatePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void LastMethod()
	{
		
	}

}
