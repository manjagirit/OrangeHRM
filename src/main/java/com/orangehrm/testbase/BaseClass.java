package com.orangehrm.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.factory.BrowserFactory;
import com.orangehrm.factory.DriverFactory;
import com.orangehrm.pageobjects.HomePage;
import com.orangehrm.pageobjects.LoginPage;
import com.orangehrm.util.Config;

public class BaseClass {
	protected WebDriver driver;
	protected LoginPage loginpage;
	protected HomePage homepage;
	
	BrowserFactory bf=new BrowserFactory();

	@BeforeMethod
	public void setUp() {
		
		String browser = Config.getProperty("browser");
		
		DriverFactory.setDriver(bf.intilize(browser));
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/orangehrm/web/index.php/auth/login");


		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		
		

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
