package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.testbase.BaseClass;
import com.orangehrm.util.Config;
import com.orangehrm.util.JavaUtil;

public class LoginTest extends BaseClass {

	@Test
	public void testValidLogin() {
		
		loginpage.enterUsername(Config.getProperty("username"));
		loginpage.enterPassword(Config.getProperty("password"));
		loginpage.clickLogin();
		String dashboard = homepage.verifyDashboard();
		Assert.assertEquals(dashboard, "Dashboard", "Dashboard is successfully displayed");

	}

	@Test
	public void testInvalidLogin() {
		
		loginpage.enterUsername(JavaUtil.randomAlphabets());
		loginpage.enterPassword(JavaUtil.randomAlphaNum());
		loginpage.clickLogin();
		String errorMsg = loginpage.verifyErrorMessage();
		Assert.assertEquals(errorMsg, "Invalid credentials");
	}
	
	@Test
	public void verifyForgetYourPassword() {
		boolean forgotPassword = loginpage.forgotYourPassword();
		Assert.assertTrue(forgotPassword);
		
		
	}

}
