package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageBETest {

    @Test
    public void testMethod(){
        RestAssured.baseURI = "https://api.practicesoftwaretesting.com";
        RequestSpecification request = RestAssured.given();
        request.header("Content-type", "application/json");
        request.header("Accept", "application/json");

        //Pasul 1: Accesam toate imaginile
        System.out.println("STEP 1: GET ALL IMAGES REQUEST");
        Response response1 = request.get("/images");
        System.out.println(response1.getStatusLine());
        response1.body().prettyPrint();
        Assert.assertEquals(response1.getStatusCode(), 200);
    }
}
