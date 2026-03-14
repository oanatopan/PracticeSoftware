package services;

import client.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ImageService {
    public void obtainAllImages(){
        System.out.println("STEP 1: GET ALL IMAGES REQUEST");
        RequestSpecification request = RestAssured.given();
        Response response1 = performRequest("GET",request,"/images");
        System.out.println(response1.getStatusLine());
        response1.body().prettyPrint();
        Assert.assertEquals(response1.getStatusCode(), 200);
    }

    private Response performRequest(String requestType, RequestSpecification request, String endpoint){
        return new RestClient().performRequest(requestType, request, endpoint);
    }
}