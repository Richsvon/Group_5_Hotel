package com.company;

import java.util.ArrayList;

public class Booking {
    private static int counter =  1;
    private final int bookingId;
    private double totalPrice;
    private int checkInDate;
    private int checkOutDate;
    private ArrayList<Room> rooms;
    private Customer customer;

    public Booking(double totalPrice, int checkInDate, int checkOutDate, ArrayList<Room> rooms, Customer customer) {
        this.bookingId = counter++;
        this.totalPrice = totalPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.rooms = rooms;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCheckInDate() {
        return checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckInDate(int checkInDate) {
        this.checkInDate = checkInDate;
    }
    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return  "\nbookingId: " + bookingId +
                "\n totalPrice: " + totalPrice +
                "\n checkInDate: " + checkInDate +
                "\n checkOutDate: " + checkOutDate +
                "\n rooms: " + rooms +
                "\n customer: " + customer +
                "\n------------------------------------- \n";
    }
}
