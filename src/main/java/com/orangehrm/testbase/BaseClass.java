package com.orangehrm.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.pageobjects.HomePage;
import com.orangehrm.pageobjects.LoginPage;

public class BaseClass {
	protected WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
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
