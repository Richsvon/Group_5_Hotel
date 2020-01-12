package com.company;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked;

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, double pricePerNight, boolean isBooked)   {
        this.setRoomNumber(roomNumber);
        this.setNumberOfBeds(numberOfBeds);
        this.setHasBalcony(hasBalcony);
        this.setPricePerNight(pricePerNight);
        this.setIsBooked(isBooked);
    }

    public void setRoomNumber (int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber () {
        return roomNumber;
    }

    public void setNumberOfBeds (int numberOfBeds)  {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds ()   {
        return numberOfBeds;
    }

    public void setHasBalcony (boolean hasBalcony)  {
        this.hasBalcony = hasBalcony;
    }

    public boolean getHasBalcony () {
        return hasBalcony;
    }

    public void setPricePerNight (double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight ()   {
        return pricePerNight;
    }

    public void setIsBooked (boolean isBooked)  {
        this.isBooked = isBooked;
    }

    public boolean getIsBooked ()   {
        return isBooked;
    }

    @Override
    public String toString() {
        return  "\nRoom number: " + roomNumber +
                "\nNumber of beds: " + numberOfBeds +
                "\nBalcony: " + hasBalcony +
                "\nPrice per night: " + pricePerNight +
                "\nRoom booked: " + isBooked +
                "\n-------------------------------------";

    }
}

