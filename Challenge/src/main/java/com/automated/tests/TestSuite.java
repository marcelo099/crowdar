package com.automated.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.automated.tests.api.ApiTesting;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    LoginTest.class,
    AgregarElementoCarrito.class,
    IncorrectLogin.class,
    ApiTesting.class
    
})

public class TestSuite {
	
	
}
