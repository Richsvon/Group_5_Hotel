package com.company;


public class Booking {

    private int bookingId;
    private double totalPrice;


    public Booking(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + "\n" +
                "Total price: " + totalPrice;
    }
}
