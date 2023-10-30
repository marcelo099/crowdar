package com.automated.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automated.tests.base.BaseTest;

public class LoginTest extends BaseTest {
	 
    
    @Before
    public void beforeTest() {
        setUp();
        driver.get("https://www.saucedemo.com/");
    	driver.manage().window().maximize();
    }

    
    @Test
    public void testLogin() {
        
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        
        //Ingreso los datos correctamente para loguearme bien
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        
        
        //se verifica que se haya pasado a la siguiente página por medio de un componente
        boolean carrito = driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        
        if (carrito) {
	        	System.out.println("El elemento fue encontrado ok.");
	        } else {
	            System.out.println("El elemento no fue encontrado.");
        }
        
        
	        try {
	    		Thread.sleep(2000);
	    	} catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        
    }
    
    @After
    public void afterTest() {
        tearDown();
    }
 
    
}

