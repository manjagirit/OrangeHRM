package com.orangehrm.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory {

	public WebDriver intilize(String browser) {
		WebDriver driver = null;

		switch (browser.toLowerCase()) {
		
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			break;
			
		case "firefox":
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");
			driver = new FirefoxDriver(foptions);
			break;
			
		case "edge":
			InternetExplorerOptions eoptions = new InternetExplorerOptions();
			eoptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(eoptions);
			break;

		default:
			throw new IllegalArgumentException("Invalid browser name in config file :"+browser);
		}
		
		return driver;

	}
	
}
