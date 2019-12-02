package com.company;

public class Booking {

    private int bookingId;
    private double TotalPrice;

    public Booking(int bookingId, double totalPrice) {
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
