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
	
	public String verifyDashboard() {
		CommonUtil.waitForVisibilityOfElement(Dashboard, driver,Integer.parseInt(Config.getProperty("timeout")));
		return Dashboard.getText();
	}
	

}
