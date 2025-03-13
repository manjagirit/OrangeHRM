package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.util.CommonUtil;
import com.orangehrm.util.Config;

public class AdminPage {

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[normalize-space()='User Management']")
	WebElement userManagement;

	public boolean isAdminManagementDisplay() {
		CommonUtil.waitForVisibilityOfElement(userManagement, driver, Integer.parseInt(Config.getProperty("timeout")));
		return userManagement.isDisplayed();

	}

}
