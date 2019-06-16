package com.capgemini.rest.tests.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.apache.http.entity.ContentType;

public class GlobalReqSpec {

    public static RequestSpecification getGlobalReqSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecBuilder.setContentType(ContentType.APPLICATION_JSON.getMimeType());

        RequestSpecification requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }


}
