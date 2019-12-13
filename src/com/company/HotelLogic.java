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


    }

    public void searchForBooking() {

    }

    public void viewCustomers() {

    }

    public void viewRooms() {

    }

    public void removeRoom() {

    }

    public void removeCustomer() {

    }

    public void viewBookings() {
        for (Booking b: bookings) {
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

        int i = 0;
        while (ID != bookings.get(i).getBookingId()) {
            if (ID != bookings.get(i).getBookingId()) {
                i++;
            } else if (ID == bookings.get(i).getBookingId()) {

            }
        }
        System.out.println("Sorry nothing matches that ID try again");

        /*for (int i = 0; i < customers.size(); i++) {
             if(Booking.get(i).getName() == (ID)){
                System.out.println("welcome \n" + customers.get(i));

            }
        }
         */
    }

    public void checkOut() {
        System.out.println("Enter customers ID");
        int bookingID = input.nextInt();

        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingId() == bookingID) {
                System.out.println("Is this the correct information ? \n" +
                        bookings.get(i).getBookingId() + "\n" +

                        "\n press 1) Yes      press 2) No");

                input.nextLine();
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Removed: " + bookings);
                        bookings.remove(i);
                        break;
                    case 2:
                        System.out.println("try again");
                        break;
                }
            }
        }
    }

    public void viewCustomerHistory() {

    }

    public void editBooking() {

    }

    public void editCustomer() {

    }

    public void addRoom() {

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
