package com.company;

import java.time.LocalDate;

public class BookingDate {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomNumber;

    public BookingDate (LocalDate checkInDate, LocalDate checkOutDate, int roomNumber)  {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomNumber = roomNumber;

    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate)  {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate)  {
        this.checkOutDate = checkOutDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber)  {
        this.roomNumber = roomNumber;
    }
}
