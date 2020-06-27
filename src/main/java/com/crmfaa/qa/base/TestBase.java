package com.crmfaa.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crmfaa.qa.util.TestUtil;
import com.crmfaa.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;//initialize the EventfiringWebDriver class variable here.
	public static WebEventListener eventListener;//initialize the WebEventListener class variable here.
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\tiwar\\eclipse-workspace\\WebdriverTest\\src\\main"
					+"\\java\\com\\crmfaa\\qa\\config\\config.properties");
			prop.load(ip);		
		    }catch(FileNotFoundException e) {
		    	e.printStackTrace();		    	
		    }catch(IOException e) {
		    	e.printStackTrace();
		    }
 }
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tiwar\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);//creating object of EventFiringWebDriver class here.
		eventListener = new WebEventListener();//creating object of WebEventListener class here.
		e_driver.register(eventListener);//need to register eventListener with e_driver by using register method we can do.
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
