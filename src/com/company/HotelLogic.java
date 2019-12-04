package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {

    ArrayList<Room> rooms = new ArrayList<>();













    public ArrayList<Room> addRoom (ArrayList rooms)   {
        Scanner input = new Scanner(System.in);

        System.out.print("Roomnumber: ");
        int RoomNumber = input.nextInt();
        System.out.print("Beds:  ");
        int NumberOfBeds = input.nextInt();
        System.out.print("Balcony ");
        boolean HasBalcony = input.nextBoolean();
        System.out.print("Price ");
        double PricePerNight = input.nextDouble();
        System.out.print("Booked ");
        boolean isBooked = input.nextBoolean();


        Room room = new Room(RoomNumber, NumberOfBeds, HasBalcony, PricePerNight, isBooked);
        rooms.add(room);

        return rooms;
    }


}
