package org.example.tests.crud;

import io.restassured.response.ValidatableResponse;
import org.example.base.CommanToAll;
import org.example.endpoints.APIConstraints;
import org.example.modules.Payloadmanager;
import org.example.pojo.BookingResponse;
import org.testng.annotations.Test;


public class Test_CreateBooking extends CommanToAll {



    @Test
    public void test_Post_Booking()
    {
        requestSpecification.basePath(APIConstraints.Create_update_Booking);
        requestSpecification.body(Payloadmanager.JsonCreateBooking());

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all().statusCode(200);

        BookingResponse bookingresponse = payloadmanager.BookingResponse(response.asString());
        System.out.println(bookingresponse.getBooking().getLastname());



    }

}
