package com.capgemini.rest.tests.initial;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteApiTest {


    @BeforeMethod
    public void beforeMethod(){
        given().log().all()
                .contentType("application/json")
                .accept("application/json")
                .body("{\n" +
                        "  \"id\": 3451,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"Burek\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteApiTest() {
        given().log().all()
                .contentType("application/json")
                .accept("application/json")
                .delete("https://petstore.swagger.io/v2/pet/3451")
                .then()
                .statusCode(200);
    }


}
