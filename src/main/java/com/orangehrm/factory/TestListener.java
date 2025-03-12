package com.orangehrm.factory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class TestListener implements ITestListener {

	static ExtentReports extent;
	private static ExtentTest test;
	private WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		ExtentManager.setTest(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentManager.getTest().pass("Test Case is passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		driver=DriverFactory.getDriver();
		String screenshotPath = captureScreenShot(driver,result.getMethod().getMethodName());
		try {
			ExtentManager.getTest().fail("Test Failed: " + result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath("."+screenshotPath).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentManager.getTest().skip("Test Case is Skipped");

	}

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentManager.reportSetup();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}
	
	private String captureScreenShot(WebDriver driver,String testName) {
		String screenshotPath = "./screenshots/"+testName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File(screenshotPath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return screenshotPath;
		
	}

}
