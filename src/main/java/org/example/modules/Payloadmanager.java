package org.example.modules;

import com.google.gson.Gson;
import org.example.pojo.*;

public class Payloadmanager {



    public static String JsonCreateBooking()
    {
        Booking booking = new Booking();
        booking.setFirstname("raja");
        booking.setLastname("ram");
        booking.setDepositpaid(true);
        booking.setTotalprice(345);
        booking.setAdditionalneeds("yes");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-09-01");
        bookingdates.setCheckout("2023-09-01");
        booking.setBookingdates(bookingdates);

        Gson gson = new Gson();
        String jsonStringBooking=gson.toJson(booking);
        return jsonStringBooking;
    }

    public static BookingResponse BookingResponse(String response)
    {
        Gson gson = new Gson();
        BookingResponse JsonBookingResponse = gson.fromJson(response, BookingResponse.class);
        return JsonBookingResponse;
    }

    public static Booking booking(String response)
    {
        Gson gson = new Gson();
        Booking jsonBooking = gson.fromJson(response, Booking.class);
        return jsonBooking;
    }


    public static String fullupdate()
    {
        Booking booking = new Booking();
        booking.setFirstname("JAI SHREE");
        booking.setLastname("ram");
        booking.setDepositpaid(true);
        booking.setTotalprice(345);
        booking.setAdditionalneeds("yes");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-09-01");
        bookingdates.setCheckout("2023-09-01");
        booking.setBookingdates(bookingdates);

        Gson gson = new Gson();
        return gson.toJson(booking);
    }

    public static String tokenCreate()
    {
        Token token = new Token();
        token.setUsername("admin");
        token.setPassword("password123");

        Gson gson = new Gson();
        return gson.toJson(token);

    }
    public static String tokenResponse(String response)
    {
        Gson gson = new Gson();
        TokenResponse jsontokenresponse = gson.fromJson(response, TokenResponse.class);
        return jsontokenresponse.getToken();
    }

}
