package com.company;

import java.util.ArrayList;

public class Booking {
    private static int counter = 1;
    private final int bookingId;
    private double totalPrice;
    private ArrayList<Room> rooms;
    private Customer customer;

    public Booking(double totalPrice, ArrayList<Room> rooms, Customer customer) {
        this.bookingId = counter++;
        this.totalPrice = totalPrice;
        this.rooms = rooms;
        this.customer = customer;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
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

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return  "\n bookingId: " + bookingId +
                "\n totalPrice: " + totalPrice +
                "\n rooms: " + rooms +
                "\n customer: " + customer +
                "\n-------------------------------------";
    }
}
