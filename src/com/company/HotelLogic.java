package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    Scanner input = new Scanner(System.in);
    public ArrayList<Room> rooms = new ArrayList<>();
    public ArrayList<Booking> bookingArr = new ArrayList<>();

    public void viewBooking () {
        
    }

    public void addRoom () {

        System.out.print("Roomnumber: ");
        int RoomNumber = input.nextInt();
        System.out.print("Beds:  ");
        int NumberOfBeds = input.nextInt();
        System.out.print("Balcony ");
        boolean HasBalcony = input.nextBoolean();
        System.out.print("Price ");
        double PricePerNight = input.nextDouble();

        Room room = new Room(RoomNumber, NumberOfBeds, HasBalcony, PricePerNight, false);
        rooms.add(room);
    }


}
