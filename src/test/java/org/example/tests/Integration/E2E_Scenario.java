package org.example.tests.Integration;

import io.qameta.allure.Description;
import org.example.base.CommanToAll;
import org.example.endpoints.APIConstraints;
import org.example.pojo.Booking;
import org.example.pojo.BookingResponse;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class E2E_Scenario extends CommanToAll {


    @Description("Verify that booking created Successfully!")
    @Test(priority = 1)
    public void test_Create_booking(ITestContext iTestContext)
    {
        requestSpecification.basePath(APIConstraints.Create_update_Booking);
        requestSpecification.body(payloadmanager.JsonCreateBooking());

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all().statusCode(200);

       BookingResponse bookingresponse= payloadmanager.BookingResponse(response.asString());
        System.out.println(bookingresponse.getBookingid());
        System.out.println(bookingresponse.getBooking().getFirstname());

        iTestContext.setAttribute("bookingid",bookingresponse.getBookingid());
    }

    @Description("Verify tha Get booking from bookingID")
    @Test(priority = 2)
    public void test_GET_Booking(ITestContext iTestContext)
    {
        Integer bookingID=(Integer) iTestContext.getAttribute("bookingid");
        System.out.println(bookingID);

        requestSpecification.basePath(APIConstraints.Create_update_Booking+"/"+bookingID);

        response = requestSpecification.when().log().all().get();

        validatableResponse = response.then().log().all().statusCode(200);

        Booking jsonbookingrs = payloadmanager.booking(response.asString());
        System.out.println(jsonbookingrs.getFirstname());
        System.out.println(jsonbookingrs.getDepositpaid());
    }

    @Description("Update the booking")
    @Test(priority = 3)
    public void test_update_booking(ITestContext iTestContext)
    {
        Integer bookingID=(Integer) iTestContext.getAttribute("bookingid");
        System.out.println(bookingID);

        requestSpecification.basePath(APIConstraints.Create_update_Booking+"/"+bookingID);
        requestSpecification.body(payloadmanager.fullupdate());

        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all().statusCode(200);

        BookingResponse updateResponse = payloadmanager.BookingResponse(response.asString());

        System.out.println(updateResponse.getBookingid());
        System.out.println(updateResponse.getBooking().getFirstname());

    }
}
