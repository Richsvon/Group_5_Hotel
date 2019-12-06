package com.company;


public class Booking {

    private int bookingId;
    private double totalPrice;
    private Customer customerInfo;
    private Room roomInfo;


    public Booking(int bookingId, double totalPrice, Customer customerInfo, Room roomInfo) {
        this.bookingId = bookingId;
        this.totalPrice = totalPrice;
        this.customerInfo = customerInfo;
        this.roomInfo = roomInfo;
    }

    public double getTotalPrice() {

        return totalPrice;
    }

    @Override
    public String toString() {
        return "Room nr:" + bookingId + "\n" +
                "TotalPrice: " + totalPrice + "kr\n" +
                "-----------------------------------";
    }
}
