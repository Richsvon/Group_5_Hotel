package com.company;

public class BookingDates {
    private int checkInDate;
    private int checkOutDate;
    private int roomNumber2;

    public BookingDates (int checkInDate, int checkOutDate, int roomNumber2) {
        this.setCheckInDate(checkInDate);
        this.setCheckOutDate(checkOutDate);
        this.setRoomNumber2(roomNumber2);

    }

    public int getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(int checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public int getRoomNumber()  {
        return roomNumber2;
    }
    public void setRoomNumber2(int roomNumber)   {
        this.roomNumber2 = roomNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Check in date: '" + checkInDate + '\'' +
                ", Check out date: '" + checkOutDate + '\'' +
                ", Room number: '" + roomNumber2;
    }
}
