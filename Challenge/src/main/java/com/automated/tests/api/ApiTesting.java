package com.automated.tests.api;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import io.restassured.response.Response;


public class ApiTesting {
	    @Test
	    public void testAPI() {
	        // URL de la API
	        String apiUrl = "https://www.mercadolibre.com.ar/menu/departments";

	        // Realizar la solicitud GET y obtener la respuesta
	        Response response = given().when().get(apiUrl);

	        // Verificar el estado de la respuesta
	        int statusCode = response.getStatusCode();
	        assertEquals("El código de estado no es el esperado", 200, statusCode);

	        // Obtener el cuerpo de la respuesta
	        String responseBody = response.getBody().asString();
	        System.out.println("Cuerpo de la respuesta: " + responseBody);

	        // Obtener los elementos de la respuesta en una lista
	        List<String> departmentNames = response.jsonPath().getList("departments.name");
	        
	        if (departmentNames != null) {
	        	System.out.println("El servicio posee por lo menos un departamento");
	        } else {
		        System.out.println("El servicio no posee ningún departamento");
	        }

	        // Imprimir listado de la respuesta
	        System.out.println("Listado de departamentos:");
	        for (String departmentName : departmentNames) {
	            System.out.println("- " + departmentName);
	        }

	        // Imprimir el JSON de respuesta
	        System.out.println("\nRespuesta con formato JSON:");
	        System.out.println(response.prettyPrint());
	    }
	    
	 	    
}
