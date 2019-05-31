package com.styleanalytics.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest extends APITestBase {

    @Test
    public void testApiResponse(){

        RequestSpecification request = getRequestSpecification();

        JSONObject requestParams = new JSONObject();
        requestParams.put("worksetId",2);
        requestParams.put("userId", 18915);

        request.body(requestParams.toJSONString());
        Response response = request.post("GetWorksetById");

        ResponseBody responseBody = response.getBody();

        System.out.println(responseBody.asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        JsonPath jsonPath = response.jsonPath();
        Boolean worksetId = jsonPath.get("status");
        Assert.assertTrue(worksetId);


    }

    @Test
    public void getActiveWorksets(){

        RequestSpecification request = getRequestSpecification();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", 1891);

        request.body(requestParams.toJSONString());
        Response response = request.post("getActiveWorksetRequest");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);


    }


}
