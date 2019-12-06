package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    Scanner input = new Scanner(System.in);

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

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

    public void addCustomer () {

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

    public void viewAvailableRooms(){
        for (int i = 0; i < rooms.size() ; i++) {
            if(rooms.get(i).getisBooked() == false ){
                System.out.println("Room [" + i + "] :");
            }
        }
    }

    public void editRoom(){
        System.out.println("Enter the index of the room you want to change: ");
        int index = Integer.parseInt(input.nextLine());
        System.out.println("Current Room info: " + rooms.get(index));

        System.out.println("Current room number: " + rooms.get(index).getRoomNumber() + " New Room Number: ");
        int roomNumber = Integer.parseInt(input.nextLine());
        rooms.get(index).setRoomNumber(roomNumber);

        System.out.println("Current number of beds: " + rooms.get(index).getNumberOfBeds() + "New number of beds: ");
        int numberOfBeds = Integer.parseInt(input.nextLine());
        rooms.get(index).setNumberOfBeds(numberOfBeds);

        System.out.println("Current Balcony status: " + rooms.get(index).getHasBalcony() + " New balcony status: ");
        Boolean hasBalcony = Boolean.parseBoolean(input.nextLine());
        rooms.get(index).setHasBalcony(hasBalcony);

        System.out.println("Current Price per night: " + rooms.get(index).getPricePerNight() + " New price per night: " );
        double pricePerNight = Double.parseDouble(input.nextLine());
        rooms.get(index).setPricePerNight(pricePerNight);
    }
}
