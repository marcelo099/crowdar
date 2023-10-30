package com.automated.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automated.tests.base.BaseTest;


public class AgregarElementoCarrito extends BaseTest {
	 
    @Before
    public void beforeTest() {
        setUp();
        driver.get("https://www.saucedemo.com/");
    	driver.manage().window().maximize();
    }

    
    @Test
    public void agregarCompraCarrito() {
        
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        
        //Ingreso los datos correctamente para loguearme bien
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        
        
        try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        
	   //selecciono el primer elemento para añadir al carrito
	   WebElement primerElemento = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	   //selecciono el elemento
	   primerElemento.click();
	   
	   //selecciono el carrito para visualizar que cargó el producto
	   WebElement carrito = driver.findElement(By.className("shopping_cart_link"));
	   //entro al carrito
	   carrito.click();
	   
	       try {
	   		Thread.sleep(2000);
		   	} catch (InterruptedException e) {
		   		// TODO Auto-generated catch block
		   		e.printStackTrace();
		   	}
	  
	  //verifico en el carrito que la cantidad de artículos esté presente
	  WebElement iconoCarrito = driver.findElement(By.className("cart_quantity"));
	       
      //se verifica que se haya pasado a la siguiente página por medio de un componente
      boolean cantidadElementos = driver.findElement(By.className("cart_quantity")).isDisplayed();
      
	    if (cantidadElementos) {
	        	System.out.println("El elemento fue agregado ok.");
	        } else {
	            System.out.println("El elemento no fue agregado.");
	    }   

	       
    }

    
    @After
    public void afterTest() {
        tearDown();
    }

    
}
