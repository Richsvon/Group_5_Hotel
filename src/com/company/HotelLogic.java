package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {







    public ArrayList<Room> rooms = new ArrayList<>();
    public ArrayList<Booking> addBooking = new ArrayList<>();

    public void roomArr () {
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

        Booking newBooking = new Booking(RoomNumber, PricePerNight);
        addBooking.add(newBooking);

        Room room = new Room(RoomNumber, NumberOfBeds, HasBalcony, PricePerNight, isBooked);
        rooms.add(room);
    }

    //Metoden för addCustomer.
    //Jag har kallat på metoden från "HotelLogic = H" i HotelApp classen.

    public void addCustomer () {
        Scanner input = new Scanner(System.in);
        Customer Costumer = new Customer("", "", "", "");

        ArrayList<Customer> customers = new ArrayList<Customer>();
        System.out.println("Enter SSN ");
        String socialSecurityNumber = input.nextLine();

        System.out.println("Enter Name ");
        String name = input.nextLine();

        System.out.println("Enter address ");
        String address = input.nextLine();

        System.out.println("Enter telephone number ");
        String telephoneNumber = input.nextLine();

        customers.add(new Customer(socialSecurityNumber, name, address, telephoneNumber));


    }

}
