package com.styleanalytics.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APITestBase {

    public RequestSpecification getRequestSpecification(){

        RestAssured.baseURI ="https://testanalyzer.styleresearch.com:60010/api/ActivityReport";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        return request;
    }
}
