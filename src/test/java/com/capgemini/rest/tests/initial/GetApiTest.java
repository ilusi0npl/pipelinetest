package com.capgemini.rest.tests.initial;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetApiTest {


    @Test
    public void getApiTest() {
        Response response = given()
                .log().all()
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/123");

        System.out.println(response.prettyPrint());

        response
                .then()
                .statusCode(200);
    }

}
