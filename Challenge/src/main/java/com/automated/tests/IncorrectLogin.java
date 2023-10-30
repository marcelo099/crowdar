package com.automated.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automated.tests.base.BaseTest;
import static org.junit.Assert.assertEquals;
import com.automated.tests.util.ScreenshotUtil;
import com.aventstack.extentreports.Status;

public class IncorrectLogin extends BaseTest {
    
    @Before
    public void beforeTest() {
        setUp();
        driver.get("https://www.saucedemo.com/");
    	driver.manage().window().maximize();
    }

    
    @Test
    public void testLogin() {
    	try {
        
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        
        //Ingreso los datos de acceso ok para el username e incorrecto el password
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("password_invalido");
        loginButton.click();
        
        try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        
	    
        //hago la captura de pantalla
        } catch (AssertionError e) {
            //si el caso falla, hace la captura de pantalla
            //logTestStatusWithScreenshot(Status.FAIL, "Login test failed");
            throw e; //
        }
	    
    }
    
    @After
    public void afterTest() {
        tearDown();
    }
 
    
	
}
