package com.styleanalytics.sumo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sumo_Test {


    public RequestSpecification getRequestSpecification(){

        RestAssured.baseURI ="https://api.sumologic.com/api/v1/search/";
        RequestSpecification request = RestAssured.given().auth().basic("suyPNbrC8ffiFg","51VrjDrgGd1NoEirz8uBQ8TTvIcXm6u8jtp5ZCRIifPr6FBDP0nidmfFkPw4t2gI") ;
        request.header("Content-Type", "application/json");
        return request;
    }

    @Test
    public void testApiResponse(){

        RequestSpecification request = getRequestSpecification();

        JSONObject requestParams = new JSONObject();
        requestParams.put("searchJobId",2);

        request.body(requestParams.toJSONString());
        Response response = request.post("jobs");

        ResponseBody responseBody = response.getBody();

        System.out.println(responseBody.asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        JsonPath jsonPath = response.jsonPath();
        Boolean worksetId = jsonPath.get("status");
        Assert.assertTrue(worksetId);


    }
}
