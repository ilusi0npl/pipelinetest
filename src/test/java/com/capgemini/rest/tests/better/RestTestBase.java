package com.capgemini.rest.tests.better;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import org.testng.annotations.BeforeSuite;

public class RestTestBase {

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";

        LogConfig logConfig = new LogConfig();
        logConfig.enablePrettyPrinting(true);
        logConfig.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.config().logConfig(logConfig);
    }


}
