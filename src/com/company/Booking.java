package com.company;

import java.util.ArrayList;

public class Booking {

    private int bookingId;
    private double TotalPrice;
    private ArrayList<Room> rooms;


    public Booking(int checkInDate,ArrayList<Room> rooms) {
        this.rooms = rooms;
        this.bookingId = bookingId;

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
