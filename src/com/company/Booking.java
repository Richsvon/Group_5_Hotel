package com.company;


public class Booking {

    private int bookingId;
    private double totalPrice;


    public Booking(int bookingId) {
        this.bookingId = bookingId;
    }


    @Override
    public String toString() {
        return "Booking ID:" + bookingId + "\n";
    }
}
