package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
    private static int counter = 1;
    private final int bookingId;
    private double totalPrice;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int room;
    private Customer customer;

    public Booking(double totalPrice, LocalDate checkInDate, LocalDate checkOutDate, int room, Customer customer) {
        this.bookingId = counter++;
        this.totalPrice = totalPrice;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.customer = customer;
    }



    public void setRoom(int room) {
        this.room = room;
    }

    public int getRoom() {
        return room;
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

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "\nbookingId: " + bookingId +
                "\n totalPrice: " + totalPrice +
                "\n checkInDate: " + checkInDate +
                "\n checkOutDate: " + checkOutDate +
                "\n rooms: " + room +
                "\n customer: " + customer +
                "\n------------------------------------- \n";
    }
}
