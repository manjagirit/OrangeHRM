package com.orangehrm.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.orangehrm.pageobjects.HomePage;
import com.orangehrm.pageobjects.LoginPage;

public class BaseClass {
	protected WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/orangehrm/web/index.php/auth/login");

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

	@BeforeClass
	public void initPageObjects() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
	}

}
