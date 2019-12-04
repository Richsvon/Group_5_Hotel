package com.company;

import java.util.ArrayList;

public class Booking {

    private int bookingId;
    private double TotalPrice;


    public Booking(int checkInDate) {
        this.bookingId = bookingId;
        TotalPrice = totalPrice;
    }

    public int getBookingId(){
        return bookingId;
    }

    @Override
    public String toString() {
        return "Room nr:" + bookingId + "\n" +
                "TotalPrice: " + TotalPrice + "kr\n" +
                "-----------------------------------";
    }
}
