package org.example.modules;

import com.google.gson.Gson;
import org.example.pojo.Booking;
import org.example.pojo.BookingResponse;
import org.example.pojo.Bookingdates;

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
}
