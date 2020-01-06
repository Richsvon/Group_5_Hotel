package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    Scanner input = new Scanner(System.in);

    /*to get the right path for the text file
    Right click the text file in /src/com.company or make your own one
    Copy path from it and paste it in pathname in File below.
     */
    File fileNameForArrString = new File("C:\\Users\\TimJo\\IdeaProjects\\Group_5_Hotel\\src\\com\\company\\textFile.txt");

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<String> arrString = new ArrayList<>();

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

    public void makeArrListToString() {
        for (int i = 0; i < bookings.size(); i++){
            String totalPrice = String.valueOf(bookings.get(i).getTotalPrice());
            String checkInDate = String.valueOf(bookings.get(i).getCheckInDate());
            String checkOutDate = String.valueOf(bookings.get(i).getCheckOutDate());
            String rooms = String.valueOf(bookings.get(i).getRooms());
            String customer = String.valueOf(bookings.get(i).getCustomer());

            String allTheInfo = "Name: " + customer + ",\n" +
                    "Has booked Room nr: " + rooms + ",\n" +
                    "Between " + checkInDate + " -- " + checkOutDate + ",\n" +
                    "Total cost: " + totalPrice;
            arrString.add(allTheInfo);
        }
        bookings.removeAll(bookings);
    }

    public void arrStringToTextFile() {
        try {
            FileWriter fw = new FileWriter(fileNameForArrString);
            Writer output = new BufferedWriter(fw);
            for ( int i = 0; i < arrString.size(); i++){
                output.write(arrString.get(i) + "\n");
            }
            output.close();
            arrString.removeAll(arrString);

        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"I can not create that file");
            e.printStackTrace();
        }
    }

    public void textFileToArrString () {
        
    }


    public boolean employeeLogIn() {
        System.out.println("Enter the employee password");
        String password = input.nextLine();
        if (!password.equals("admin")) {
            System.out.println("Wrong password");
            return false;
        } else if (password.equals("admin")) {
            System.out.println("Succesfull log in");
        }
        return true;
    }

    public int customerLogIn() {
        boolean logIn = true;
        int index = -1;
        while (logIn) {
            System.out.println("Do you have an account press 1, 2 to create a new and 3 to exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter your name");
                    String name = input.nextLine();
                    System.out.println("Enter your SSN ");
                    String SSN = input.nextLine();
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getName().equalsIgnoreCase(name) && customers.get(i).getSocialSecurityNumber().equals(SSN)) {
                            index = i;
                            System.out.println("You are now logged in as " + customers.get(i).getName() + " with the SSN " + customers.get(i).getSocialSecurityNumber());
                            logIn = false;
                        }
                    }
                    if (index == -1) {
                        System.out.println("There is no such customer");
                    }
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    return index;
                default:
                    System.out.println("invalid input, 1 or 2");
                    break;
            }
        }
        return index;
    }

    public void searchForBooking() {

    }

    public void viewCustomers() {
        System.out.println("Printing a list of all customers");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < customers.size(); i++) {
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
        for (int i = 0; i < rooms.size(); i++) {
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

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                rooms.remove(i);
                System.out.println("Room was successfully removed");
            }
        }

    }

    public void removeCustomer() {
        System.out.println("Enter the name of the customer you would like to remove:");
        String name = input.nextLine();

        for (int i = 0; i < customers.size(); i++) {
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

    public void makeBooking(int customerIndex) {
        double totalPrice = 0;
        ArrayList<Room> roomsToBook = new ArrayList<>();
        if (customerIndex == -1) {
            System.out.println("Enter the SSN of the customer that is making the booking (YYMMDDXXXX");
            String SSN = input.nextLine();
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getSocialSecurityNumber().equalsIgnoreCase(SSN)) {
                    customerIndex = i;
                }
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
        //ask for ssn
        //step 2
        System.out.println(bookings.get(1).getCustomer());
        System.out.println("enter your ssn");
        String ssn = input.nextLine();
        for (int i = 0; i < bookings.size(); i++) {

            if (bookings.get(i).getCustomer().getSocialSecurityNumber().equals(ssn)) {
                break;
            }
        }
        //---------------------------------------------------------------------------------------------
        //witch booking id?
        System.out.println("Enter Booking ID: ");
        int bookingId = input.nextInt();
        bookingId--;
        //int bookingIndex;
        Booking temp;

        System.out.println(bookings.get(bookingId));
        input.nextLine();

        for (int i = 0; i < bookings.size(); i++) {
            temp = bookings.get(i);
            //go through the booking room is booked and change it all to true
            if (bookings.get(i).getBookingId() == bookingId) {
                temp.getRooms().get(i).getisBooked();

                while (!temp.getRooms().get(i).getisBooked()) {
                    temp.getRooms().get(i).setisBooked(true);
                    if (temp.getRooms().get(i).getisBooked()) {
                        i++;
                    }
                }
                System.out.println(temp.getRooms());


                //bookingIndex = i;
                //rooms.get(bookingIndex).setisBooked(true);
                //System.out.println(customers.get(bookingId) + "\n" +
                //bookings.get(bookingIndex));
            }
        }
    }

    public void checkOut() {
        System.out.println("Enter customers ID");
        int bookingId = input.nextInt();
        int bookingIndex = 0;
        System.out.println(bookings.get(bookingIndex + 1));
        input.nextLine();

        for (int i = 0; i < bookings.size(); i++) {

            if (bookings.get(i).getBookingId() == bookingId) {
                bookingIndex = i;
                System.out.println(customers.get(bookingId));
            }
        }
        rooms.get(bookingIndex).setisBooked(false);
        System.out.println(bookings.get(bookingIndex));
    }

    public void viewCustomerHistory() {

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
        boolean edit = true;
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println("Room [" + i + "] " + rooms.get(i));
        }
        while (edit) {
            System.out.println("Enter the index of the room you want to change: ");
            int index = Integer.parseInt(input.nextLine());
            System.out.println("Current Room info: " + rooms.get(index));

            System.out.println("edit 1, room number 2, number of beds 3, balcony 4, price per night 5, to exit editing ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Current room number: " + rooms.get(index).getRoomNumber() + " New Room Number: ");
                    int roomNumber = Integer.parseInt(input.nextLine());
                    rooms.get(index).setRoomNumber(roomNumber);
                    break;
                case 2:
                    System.out.println("Current number of beds: " + rooms.get(index).getNumberOfBeds() + "New number of beds: ");
                    int numberOfBeds = Integer.parseInt(input.nextLine());
                    rooms.get(index).setNumberOfBeds(numberOfBeds);
                    break;
                case 3:
                    System.out.println("Current Balcony status: " + rooms.get(index).getHasBalcony() + " New balcony status: ");
                    Boolean hasBalcony = Boolean.parseBoolean(input.nextLine());
                    rooms.get(index).setHasBalcony(hasBalcony);
                    break;
                case 4:
                    System.out.println("Current Price per night: " + rooms.get(index).getPricePerNight() + " New price per night: ");
                    double pricePerNight = Double.parseDouble(input.nextLine());
                    rooms.get(index).setPricePerNight(pricePerNight);
                    break;
                case 5:
                    edit = false;
                    break;
                default:
                    System.out.println("invalid input, 1-5");
                    break;
            }
        }
    }

    public void viewAvailableRoomsByDate() {

    }

    public void viewBookingHistory(int customerIndex) {
        ArrayList<Booking> yourBookings = new ArrayList<>();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getCustomer() == customers.get(customerIndex)) {
                yourBookings.add(bookings.get(i));
            }
        }
        System.out.println(yourBookings);

    }

    public void editProfile(int index) {
        boolean exit = true;
        while (exit) {
            System.out.println("edit 1,SSN 2,name 3, address 4, phone number 5, exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Current social security number: " + customers.get(index).getSocialSecurityNumber() + "\nEnter a new social security number: ");
                    String SocialSecurityNumber = input.nextLine();
                    customers.get(index).setSocialSecurityNumber(SocialSecurityNumber);
                    break;
                case 2:
                    System.out.print("Current name: " + customers.get(index).getName() + "\nNew name: ");
                    String name = input.nextLine();
                    customers.get(index).setName(name);
                    break;
                case 3:
                    System.out.print("Current address: " + customers.get(index).getAddress() + "\nEnter a new address: ");
                    String address = input.nextLine();
                    customers.get(index).setAddress(address);
                    break;
                case 4:
                    System.out.print("Current phone number: " + customers.get(index).getTelephoneNumber() + "\nEnter a new phone number: ");
                    String TelephoneNumber = input.nextLine();
                    customers.get(index).setTelephoneNumber(TelephoneNumber);
                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    System.out.println("Ivalid input, 1-5");
                    break;
            }
        }
    }

    public void printCustomerMenu() {
        System.out.println("---- Hello and Welcome to our Hotel Application ----");
        System.out.println("------------------------------------------------");
        System.out.println("1: View available rooms");
        System.out.println("------------------------------------------------");
        System.out.println("2: View booking history");
        System.out.println("------------------------------------------------");
        System.out.println("3: Make a new booking");
        System.out.println("------------------------------------------------");
        System.out.println("4: Edit your info");
        System.out.println("------------------------------------------------");
        System.out.println("5: Exit to log in menu");
        System.out.println("------------------------------------------------");
    }

    public void printEmployeeMenu() {
        System.out.println("---- Hello and Welcome to our Hotel Application ----");
        System.out.println("------------------------------------------------");
        System.out.println("1: View all customers.");
        System.out.println("------------------------------------------------");
        System.out.println("2: View all rooms.");
        System.out.println("------------------------------------------------");
        System.out.println("3: View available rooms.");
        System.out.println("------------------------------------------------");
        System.out.println("4: Add room.");
        System.out.println("------------------------------------------------");
        System.out.println("5: Edit room.");
        System.out.println("------------------------------------------------");
        System.out.println("6: remove room.");
        System.out.println("------------------------------------------------");
        System.out.println("7: Add customer.");
        System.out.println("------------------------------------------------");
        System.out.println("8: remove customer.");
        System.out.println("------------------------------------------------");
        System.out.println("9: Search for bookingID.");
        System.out.println("------------------------------------------------");
        System.out.println("10: Make booking.");
        System.out.println("------------------------------------------------");
        System.out.println("11: Check in.");
        System.out.println("------------------------------------------------");
        System.out.println("12: Check out.");
        System.out.println("------------------------------------------------");
        System.out.println("13: View customers bookings, current and previous.");
        System.out.println("------------------------------------------------");
        System.out.println("14: Edit booking.");
        System.out.println("------------------------------------------------");
        System.out.println("15: Edit customer.");
        System.out.println("------------------------------------------------");
        System.out.println("16: Exit to log in menu!");
        System.out.println("------------------------------------------------");
    }
}
