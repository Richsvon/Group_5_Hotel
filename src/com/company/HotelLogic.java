package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    Scanner input = new Scanner(System.in);

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addTestObjects(){
        //lägger till 3 rum och 3 customers för att kunna testa metoder.
        rooms.add(new Room(1,1,false,99,false));
        rooms.add(new Room(2,2,false,99,true));
        rooms.add(new Room(3,3,true,99,false));
        customers.add(new Customer("11","Richard","vägen11","0701111"));
        customers.add(new Customer("22","Tim","vägen22","0702222"));
        customers.add(new Customer("33","Jesper","vägen33","0703333"));
        customers.add(new Customer("44","Achmaad", "vägen44","0704444"));



    }
    public void viewCustomers(){
        for (Customer c: customers) {
            System.out.println(c);
        }
    }
    public void viewRooms(){

    }
    public void removeRoom(){

    }
    public void removeCustomer(){

    }
    public void searchForBooking(){

    }
    public void makeBooking(){
        int id = 0;

        new Booking(id,);
        System.out.println("Welcome to HKR Hotel\n" +
                "to make a booking please follow these instructions");
        addCustomer();
        for (int i = 0; i < bookings.size(); i++){

        }

    }
    public void checkIn(){

    }
    public void checkOut(){

    }
    public void viewCustomerHistory(){

    }
    public void editBooking(){

    }
    public void editCustomer(){

    }
    public void setIDMethod () {
        int id = 0;
        while (rooms.get(id) != null) {

        }
    }

    public void getBooking () {
        System.out.println("Enter ID of the person you want to change");
        int id = input.nextInt();
        System.out.println(bookings.get(id));

    }

    public void addRoom () {

        System.out.print("Roomnumber: ");
        int RoomNumber = Integer.parseInt(input.nextLine());
        System.out.print("Beds:  ");
        int NumberOfBeds = Integer.parseInt(input.nextLine());
        System.out.print("Balcony ");
        boolean HasBalcony = Boolean.parseBoolean(input.nextLine());
        System.out.print("Price ");
        double PricePerNight = Double.parseDouble(input.nextLine());

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
                System.out.println(rooms.get(i));
            }
        }
    }

    public void editRoom(){
        for (int i = 0; i < rooms.size() ; i++) {
            System.out.println("Room [" + i + "] " + rooms.get(i));
        }

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
