package com.orangehrm.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> tdriver=new ThreadLocal<>();
	
	public static void setDriver(WebDriver setdriver) {
		tdriver.set(setdriver);
		
	}
	
	public static WebDriver getDriver() {
		return tdriver.get();
	}
	
	public static void removeDriver() {
		if(tdriver!=null) {
			tdriver.get().quit();
			tdriver.remove();
		}
		
	}
	
	
	
	
	
	
	

}
