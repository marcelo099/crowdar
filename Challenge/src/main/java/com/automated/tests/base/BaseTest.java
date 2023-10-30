package com.automated.tests.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

	public class BaseTest {
	    protected WebDriver driver;
	    protected ExtentReports extent;
	    protected ExtentTest test;
	    
	    
	    @Before
	    public void setUp() {
	        //System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
	        //driver = new ChromeDriver();
	        System.setProperty("webdriver.edge.driver","c:\\drivers\\msedgedriver.exe");
	        driver = new EdgeDriver();
	    	
	        extent = new ExtentReports();
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent-report.html");
	        extent.attachReporter(htmlReporter);

	    }
	    
	    
	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	        extent.flush();
	    }
	    
	    public void logTestStatus(Status status, String message) {
	        test.log(status, message);
	    }
	    
	    
//	    public void logTestStatusWithScreenshot(Status status, String message) {
//	        test.log(status, message);
//	        try {
//	            // Utilize the ScreenshotUtil to capture and attach screenshots
//	            ScreenshotUtil.captureScreenshot(driver, test.getMethod().getMethodName());
//	            test.addScreenCaptureFromPath("screenshots/" + test.getMethod().getMethodName() + ".jpg");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
	    
	    
}
