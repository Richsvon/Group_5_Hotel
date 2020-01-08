package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    Scanner input = new Scanner(System.in);

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addTestObjects() {
        //lägger till 3 rum och 3 customers för att kunna testa metoder.
        rooms.add(new Room(1, 1, false, 99, false));
        rooms.add(new Room(2, 2, false, 99, true));
        rooms.add(new Room(3, 3, true, 99, false));
        customers.add(new Customer("11", "Richard", "vägen11", "0701111"));
        customers.add(new Customer("22", "Tim", "vägen22", "0702222"));
        customers.add(new Customer("33", "Jesper", "vägen33", "0703333"));
        customers.add(new Customer("44", "Achmaad", "vägen44", "0704444"));

        bookings.add(new Booking(99, 191201, 191205, rooms, customers.get(0)));
        bookings.add(new Booking(199, 191206, 191209, rooms, customers.get(1)));
        bookings.add(new Booking(150, 191213, 191226, rooms, customers.get(2)));


    }

    public void searchForBooking() {
        System.out.println("Print a specific customer");
        System.out.println("-----------------------------------------------");

        System.out.println("enter booking ID");
        int m;
        m = input.nextInt();

        for (int i = 0; i < bookings.size(); i++) {
            //System.out.println("Enter social security number " + customers.get(i).getSocialSecurityNumber());
            //m = input.nextInt();
            bookings.get(i).getBookingId();
            int ID = bookings.get(i).getBookingId();
            if (ID == m)
            {
                System.out.println("BookingId " + bookings.get(i).getBookingId());
                System.out.println("Total price: " + bookings.get(i).getTotalPrice());
                System.out.println("Check in: " + bookings.get(i).getCheckInDate());
                System.out.println("Check out: " + bookings.get(i).getCheckOutDate());
                System.out.println("-----------------------------------------------");
            }
        }

        System.out.println("Search for room");
        System.out.println("-----------------------------------------------");

        System.out.println("enter room number");
        int n;
        n = input.nextInt();

        for (int i = 0; i < rooms.size(); i++) {
            //System.out.println("Enter social security number " + customers.get(i).getSocialSecurityNumber());
            //m = input.nextInt();
            rooms.get(i).getRoomNumber();
            int room = rooms.get(i).getRoomNumber();
            if (room == n)
            {
                System.out.println("Room number: " + rooms.get(i).getRoomNumber());
                System.out.println("Number of beds: " + rooms.get(i).getRoomNumber());
                System.out.println("Balcony : " + rooms.get(i).getRoomNumber());
                System.out.println("Price per night: " + rooms.get(i).getRoomNumber());
                System.out.println("Is the room booked: " + rooms.get(i).getRoomNumber());
                System.out.println("-----------------------------------------------");
            }
        }
    }

    public void viewCustomers() {
        System.out.println("Printing a list of all customers");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < customers.size(); i++)  {
            System.out.println("Social security number: " + customers.get(i).getSocialSecurityNumber());
            System.out.println("Name: " + customers.get(i).getName());
            System.out.println("Address: " + customers.get(i).getAddress());
            System.out.println("Telephone: " + customers.get(i).getTelephoneNumber());
            System.out.println("-----------------------------------------------");
        }
    }

    public void viewRooms() {
        System.out.println("Printing a list of all rooms");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < rooms.size(); i++)  {
            System.out.println("Room number: " + rooms.get(i).getRoomNumber());
            System.out.println("Number of beds: " + rooms.get(i).getRoomNumber());
            System.out.println("Balcony : " + rooms.get(i).getRoomNumber());
            System.out.println("Price per night: " + rooms.get(i).getRoomNumber());
            System.out.println("Is the room booked: " + rooms.get(i).getRoomNumber());
            System.out.println("-----------------------------------------------");
        }

    }

    public void removeRoom() {
        System.out.println("Enter the room number of the room you would like to remove:");
        int roomNumber = Integer.parseInt(input.nextLine());

        for (int i = 0; i < rooms.size(); i++)  {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                rooms.remove(i);
                System.out.println("Room was successfully removed");
            }
        }

    }

    public void removeCustomer() {
        System.out.println("Enter the name of the customer you would like to remove:");
        String name = input.nextLine();

        for (int i = 0; i < customers.size(); i++)  {
            if (customers.get(i).getName().equals(name)) {
                customers.remove(i);
                System.out.println("Customer was successfully removed");
            }
        }
    }

    public void viewBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    public void makeBooking() {
        double totalPrice = 0;
        ArrayList<Room> roomsToBook = new ArrayList<>();

        System.out.println("Enter the SSN of the customer that is making the booking (YYMMDDXXXX");
        String SSN = input.nextLine();
        int customerIndex = 0;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getSocialSecurityNumber().equalsIgnoreCase(SSN)) {
                customerIndex = i;
            }
        }

        System.out.println("How many rooms do you want to book");
        int numberOfRooms = Integer.parseInt(input.nextLine());

        System.out.println("Enter check in date: (format YYMMDD");
        int checkInDate = Integer.parseInt(input.nextLine());

        System.out.println("Enter check out date: (format YYMMDD");
        int checkOutDate = Integer.parseInt(input.nextLine());

        int numberOfNights = checkOutDate - checkInDate;

        for (int i = 0; i < numberOfRooms; i++) {
            int roomIndex = 0;
            viewAvailableRooms();
            System.out.println("Enter the roomnumber of the room you want to book");
            int roomNumber = Integer.parseInt(input.nextLine());
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(i).getRoomNumber() == roomNumber) {
                    roomIndex = j;
                }

            }
            totalPrice = totalPrice + (rooms.get(roomIndex).getPricePerNight() * numberOfNights);
            roomsToBook.add(rooms.get(roomIndex));
        }
        bookings.add(new Booking(totalPrice, checkInDate, checkOutDate, roomsToBook, customers.get(customerIndex)));
        viewBookings();
    }

    public void checkIn() {
        System.out.println("Check in with your ID: ");

        int ID = input.nextInt();
/*
        if (bookings.get(ID).getBookingId() == ID) {
            System.out.println(bookings.get(ID));
        } else {
            System.out.println("Sorry nothing matches that ID try again");
        }
 */
        for (int i = 0; i < bookings.size(); i++) {
            if(bookings.get(i).getBookingId() == (ID)){
                System.out.println("welcome \n" + bookings.get(ID));
            }
        }
    }

    public void checkOut() {
        System.out.println("Enter customers ID");
        int bookingID = input.nextInt();

        System.out.println("is this the correct information? \n" +
                bookings.get(bookingID) + "\n" +
                "press 1) Yes       press 2) No");

        int choice = input.nextInt();
        switch (choice){
            case 1:
                bookings.remove(bookingID);
            case 2:
                System.out.println("returning to menu");
                break;

        }
        input.nextLine();
        input.nextLine();

    }

    public void viewCustomerHistory() {
        System.out.println("Print a specific customer");
        System.out.println("-----------------------------------------------");

        System.out.println("enter ssn");
        int m;
        m = input.nextInt();

        for (int i = 0; i < customers.size(); i++) {
            //System.out.println("Enter social security number " + customers.get(i).getSocialSecurityNumber());
            //m = input.nextInt();
            customers.get(i).getSocialSecurityNumber();
            String ssn = customers.get(i).getSocialSecurityNumber();
            if (ssn.equals(String.valueOf(m))){
                System.out.println("Social security number: " + customers.get(i).getSocialSecurityNumber());
                System.out.println("Name: " + customers.get(i).getName());
            System.out.println("Address: " + customers.get(i).getAddress());
           System.out.println("Telephone: " + customers.get(i).getTelephoneNumber());
           System.out.println("-----------------------------------------------");
            }
        }



    }

    public void editBooking() {
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("Index (" + i + ")");
            System.out.println("BookingId " + bookings.get(i).getBookingId());
            System.out.println("Total price: " + bookings.get(i).getTotalPrice());
            System.out.println("Check in: " + bookings.get(i).getCheckInDate());
            System.out.println("Check out: " + bookings.get(i).getCheckOutDate());
            System.out.println("-----------------------------------------------");

            System.out.println("Enter the index of the booking you want to change: ");
            int index = Integer.parseInt(input.nextLine());

            System.out.println("------------ Current customer info ------------");
            System.out.println("BookingId " + bookings.get(index).getBookingId());
            System.out.println("Total price: " + bookings.get(index).getTotalPrice());

            System.out.println("Check in: " + bookings.get(index).getCheckInDate());
            System.out.println("Check out: " + bookings.get(index).getCheckOutDate());
            System.out.println("-----------------------------------------------");

            System.out.print("Current Check In: " + bookings.get(index).getCheckInDate() + "\nNew Check In: ");
            int checkInDate = input.nextInt();
            bookings.get(index).setCheckInDate(checkInDate);

            System.out.print("Current Check Out: " + bookings.get(index).getCheckInDate() + "\nNew Check Out: ");
            int checkOutDate = input.nextInt();
            bookings.get(index).setCheckOutDate(checkOutDate);

            System.out.println("\nNew Check In: " + checkInDate);
            System.out.println("\nNew Check Out: " + checkOutDate);


            // Customer får inte ändra på dessa features

            // System.out.println("BookingId " + bookings.get(i).getBookingId());

//            System.out.print("Current Total Price: " + bookings.get(index).getBookingId() + "\nEnter new Total price ");
//            double totalPrice = input.nextDouble();
//            bookings.get(index).setTotalPrice(totalPrice);


        }

    }

    public void editCustomer() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Index (" + i + ")");
            System.out.println("Social security number: " + customers.get(i).getSocialSecurityNumber());
            System.out.println("Name: " + customers.get(i).getName());
            System.out.println("Address: " + customers.get(i).getAddress());
            System.out.println("Telephone: " + customers.get(i).getTelephoneNumber());
            System.out.println("-----------------------------------------------");
        }
        System.out.println("Enter the index of the customer you want to change: ");
        int index = Integer.parseInt(input.nextLine());

        System.out.println("------------ Current customer info ------------");
        System.out.println("Social security number: " + customers.get(index).getSocialSecurityNumber());
        System.out.println("Name: " + customers.get(index).getName());
        System.out.println("Address: " + customers.get(index).getAddress());
        System.out.println("Telephone: " + customers.get(index).getTelephoneNumber());
        System.out.println("-----------------------------------------------");


        System.out.print("Current social security number: " + customers.get(index).getSocialSecurityNumber() + "\nEnter a new social security number: ");
        String SocialSecurityNumber = input.nextLine();
        customers.get(index).setSocialSecurityNumber(SocialSecurityNumber);

        System.out.print("Current name: " + customers.get(index).getName() + "\nNew name: ");
        String name = input.nextLine();
        customers.get(index).setName(name);

        System.out.print("Current address: " + customers.get(index).getAddress() + "\nEnter a new address: ");
        String address = input.nextLine();
        customers.get(index).setAddress(address);

        System.out.print("Current phone number: " + customers.get(index).getTelephoneNumber() + "\nEnter a new phone number: ");
        String TelephoneNumber = input.nextLine();
        customers.get(index).setTelephoneNumber(TelephoneNumber);
    }

    public void addRoom() {

        System.out.print("Room number: ");
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

    public void addCustomer() {

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

    public void viewAvailableRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getisBooked() == false) {
                System.out.println(rooms.get(i));
            }
        }
    }

    public void editRoom() {
        for (int i = 0; i < rooms.size(); i++) {
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

        System.out.println("Current Price per night: " + rooms.get(index).getPricePerNight() + " New price per night: ");
        double pricePerNight = Double.parseDouble(input.nextLine());
        rooms.get(index).setPricePerNight(pricePerNight);
    }
}
