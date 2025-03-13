package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.util.CommonUtil;
import com.orangehrm.util.Config;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginBtn;
	@FindBy(xpath="//p[contains(.,'Forgot your password? ')]")
	WebElement forgotPasswordLink;
	@FindBy(xpath="//p[contains(.,'Invalid credentials')]")
	WebElement errorMessage;
	
	public void enterUsername(String Username) {
		CommonUtil.waitForVisibilityOfElement(username, driver,Integer.parseInt(Config.getProperty("timeout")));
		username.sendKeys(Username);
	}
	
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void loginValidData(String Username,String Password) {
		
		CommonUtil.waitForVisibilityOfElement(username, driver,Integer.parseInt(Config.getProperty("timeout")));
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginBtn.click();
		
	}
	
	public boolean forgotYourPassword() {
		CommonUtil.waitForVisibilityOfElement(forgotPasswordLink, driver,Integer.parseInt(Config.getProperty("timeout")));
		return forgotPasswordLink.isDisplayed();
	}
	
	public void verifyForgotYourPasswordLink() {
		forgotPasswordLink.click();
	}
	
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String verifyErrorMessage() {
		CommonUtil.waitForVisibilityOfElement(errorMessage, driver,Integer.parseInt(Config.getProperty("timeout")) );
		return errorMessage.getText();
	}
	

}
