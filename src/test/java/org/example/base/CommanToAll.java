package org.example.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.endpoints.APIConstraints;
import org.example.modules.Payloadmanager;
import org.testng.annotations.BeforeTest;

public class CommanToAll {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public Payloadmanager payloadmanager;



    @BeforeTest
    public void baseSetup()
    {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstraints.BASE_URL);
        requestSpecification.contentType(ContentType.JSON);
    }
}
