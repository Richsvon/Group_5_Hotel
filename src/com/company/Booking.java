package com.company;


public class Booking {

    private int bookingId;
    private double totalPrice;



    public Booking(int bookingId, double totalPrice) {
        this.bookingId = bookingId;
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "Room nr:" + bookingId + "\n" +
                "TotalPrice: " + totalPrice + "kr\n" +
                "-----------------------------------";
    }
}
