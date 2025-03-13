package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.util.CommonUtil;
import com.orangehrm.util.Config;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span/child::h6[contains(.,\"Dashboard\")]")
	WebElement Dashboard;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement Logout;
	
	@FindBy(xpath="//p[contains(.,'Manjunath T')]")
	WebElement profileDropdown;
	
	@FindBy(xpath="//span[normalize-space()='Admin']")
	WebElement Admin;
	
	public String dashboard() {
		CommonUtil.waitForVisibilityOfElement(Dashboard, driver,Integer.parseInt(Config.getProperty("timeout")));
		return Dashboard.getText();
	}
	
	public void profiledropdown() {
		CommonUtil.waitForVisibilityOfElement(profileDropdown, driver,Integer.parseInt(Config.getProperty("timeout")));
		CommonUtil.clickOnElement(profileDropdown);
		}
	
	public void clickLogout() {
		CommonUtil.clickOnElement(Logout);
	}
	
	public void clickAdmin() {
		CommonUtil.waitForVisibilityOfElement(Admin, driver,Integer.parseInt(Config.getProperty("timeout")));
	CommonUtil.clickOnElement(Admin);	
	}
	

}
