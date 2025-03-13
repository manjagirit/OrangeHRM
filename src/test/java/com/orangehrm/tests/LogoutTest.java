package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.testbase.BaseClass;
import com.orangehrm.util.Config;

public class LogoutTest extends BaseClass{
	
	@Test
	public void testLogout() {
		loginpage.loginValidData(Config.getProperty("username"),Config.getProperty("password"));
		homepage.profiledropdown();
		homepage.clickLogout();
		Assert.assertTrue(loginpage.forgotYourPassword(),"Logout is successfully tested");
		
}
	@Test
	public void verifyAdminPanelDisplay()  {
		loginpage.loginValidData(Config.getProperty("username"),Config.getProperty("password"));
		homepage.clickAdmin();
		boolean adminmanagement = adminpage.isAdminManagementDisplay();
		Assert.assertTrue(adminmanagement,"Admin Management page is displayed ");
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
