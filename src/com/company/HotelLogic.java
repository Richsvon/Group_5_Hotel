package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelLogic {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    /*to get the right path for the text file
    Right click the text file in /src/com.company or make your own one
    Copy path from it and paste it in pathname in File below.
     */
    private File fileNameForArrString = new File("C:\\Users\\TimJo\\IdeaProjects\\Group_5_Hotel\\src\\com\\company\\textFile.txt");

    private ArrayList<Booking> arrBookingCopy = new ArrayList<>();
    private ArrayList<String> arrString = new ArrayList<>();

    public void addTestObjects() {
        rooms.add(new Room(1, 1, false, 99, false));
        rooms.add(new Room(2, 2, false, 99, false));
        rooms.add(new Room(3, 3, true, 99, false));

        customers.add(new Customer("9801010000", "Richard", "vägen11", "0701111"));
        customers.add(new Customer("9801020000", "Tim", "vägen22", "0702222"));
        customers.add(new Customer("9801030000", "Jesper", "vägen33", "0703333"));
        customers.add(new Customer("9801040000", "Achmaad", "vägen44", "0704444"));

        bookings.add(new Booking(99, rooms, customers.get(0)));
        bookings.add(new Booking(199, rooms, customers.get(1)));
        bookings.add(new Booking(150, rooms, customers.get(2)));
    }


    public void makeArrListToString() {
        arrBookingCopy.addAll(bookings);
        for (int i = 0; i < bookings.size(); i++) {
            String totalPrice = String.valueOf(arrBookingCopy.get(i).getTotalPrice());
            String rooms = String.valueOf(arrBookingCopy.get(i).getRooms());
            String customer = String.valueOf(arrBookingCopy.get(i).getCustomer());

            String allTheInfo = "Info about: " + customer + ",\n" +
                    "Has booked Room nr: " + rooms + ",\n" +
                    "Total cost: " + totalPrice + "\n" +
                    "--------------------------------------------------------------------------------------";
            arrString.add(allTheInfo);
        }
        arrBookingCopy.removeAll(arrBookingCopy);
    }

    public void arrStringToTextFile() {
        try {
            FileWriter fw = new FileWriter(fileNameForArrString);
            Writer output = new BufferedWriter(fw);
            for (int i = 0; i < arrString.size(); i++) {
                output.write(arrString.get(i) + "\n");
            }
            output.close();
            arrString.removeAll(arrString);

            textFileToArrString();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "I can not create that file");
            e.printStackTrace();
        }
    }

    public void textFileToArrString() {
        try {
            String line;
            BufferedReader in = new BufferedReader(new FileReader(fileNameForArrString));
            if (!in.ready()) {
                throw new IOException();
            }
            while ((line = in.readLine()) != null) {
                arrString.add(line);
            }
            in.close();

        } catch (IOException e) {
            System.out.println("ERROR Something went wrong");
        }
    }

    public void viewTextFiles() {
        System.out.println("From string array");
        for (String s : arrString) {
            System.out.println(s);
        }
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
            System.out.println("\n 1: Already a customer \n 2: Become a customer \n 3: Exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter your name");
                    String name = input.nextLine();

                    String SSN = "";
                    while (SSN.length() != 10) {
                        System.out.println("Enter your SSN ");
                        SSN = input.nextLine();
                        if (SSN.length() != 10) {
                            System.out.println("SSN should be in format (YYMMDDXXXX");
                        }
                    }

                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getName().equalsIgnoreCase(name) &&
                                customers.get(i).getSocialSecurityNumber().equals(SSN)) {
                            index = i;
                            System.out.println("You are now logged in as " + customers.get(i).getName() +
                                    " with the SSN " + customers.get(i).getSocialSecurityNumber());
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
                    System.out.println("invalid input, 1-3");
                    break;
            }
        }
        return index;
    }

    public void searchForBooking() {
        int maxBookID = bookings.size();
        int bookingID = 0;
        while (bookingID < 1 || bookingID > maxBookID) {
            System.out.println("Enter booking ID");
            bookingID = Integer.parseInt(input.nextLine());
            if (bookingID < 1 || bookingID > maxBookID) {
                System.out.println("Booking ID must be between 1 and " + maxBookID + ".");
            }
        }
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingId() == bookingID) {
                System.out.println(bookings.get(i));
            }
        }
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
            System.out.println("Number of beds: " + rooms.get(i).getNumberOfBeds());
            System.out.println("Balcony : " + rooms.get(i).getHasBalcony());
            System.out.println("Price per night: " + rooms.get(i).getPricePerNight());
            System.out.println("Is the room booked: " + rooms.get(i).getIsBooked());
            System.out.println("-----------------------------------------------");
        }

    }

    public void removeRoom() {
        viewRooms();
        boolean remove = true;
        while (remove) {
            int roomNumber = 0;
            while (roomNumber < 1) {
                System.out.print("Room number: ");
                roomNumber = Integer.parseInt(input.nextLine());
                if (roomNumber < 1) {
                    System.out.println("Room number must be a positive number!");
                }
            }

            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getRoomNumber() == roomNumber) {
                    rooms.remove(i);
                    System.out.println("Room was successfully removed");
                    remove = false;
                }
            }
            if (remove) {
                System.out.println("The room number does not exist");
            }
        }
    }

    public void removeCustomer() {
        boolean match = true;
        while (match) {
            System.out.println("Enter the name of the customer you would like to remove:");
            String name = input.nextLine();

            String SSN = "";
            while (SSN.length() != 10) {
                System.out.println("Enter the SSN of the customer.");
                SSN = input.nextLine();
                if (SSN.length() != 10) {
                    System.out.println("SSN should be in format (YYMMDDXXXX)");
                }
            }

            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getName().equalsIgnoreCase(name)
                        && customers.get(i).getSocialSecurityNumber().equals(SSN)) {
                    customers.remove(i);
                    System.out.println("Customer was successfully removed");
                    match = false;
                }
            }
            if (match) {
                System.out.println("There is no customer with that name and SSN.");
            }
        }
        System.out.println();
    }

    public void viewBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    public void makeBooking(int customerIndex) {
        if (customerIndex == -1) {
            customerIndex = correctSSN();
        }

        double totalPrice = 0;
        ArrayList<Room> roomsToBook = new ArrayList<>();

        int numberOfRooms = 0;
        while (numberOfRooms < 1) {
            System.out.println("How many rooms do you want to book");
            numberOfRooms = Integer.parseInt(input.nextLine());
            if (numberOfRooms < 1) {
                System.out.println("You must book atleast one room.");
            }
        }

        int numberOfNights = 0;
        while (numberOfNights < 1) {
            System.out.println("How many nights do you want to book?");
            numberOfNights = Integer.parseInt(input.nextLine());
            if (numberOfNights < 1) {
                System.out.println("You must book atleast one night.");
            }
        }

        for (int i = 0; i < numberOfRooms; i++) {
            int roomIndex = -1;
            while (roomIndex == -1) {
                viewAvailableRooms();
                System.out.println("Enter the room number of the room you want to book!");
                int roomNumber = Integer.parseInt(input.nextLine());
                for (int j = 0; j < rooms.size(); j++) {
                    if (rooms.get(i).getRoomNumber() == roomNumber) {
                        roomIndex = j;
                    }
                }
                if (roomIndex == -1) {
                    System.out.println("That room number does not exist");
                }
            }
            totalPrice = totalPrice + (rooms.get(roomIndex).getPricePerNight() * numberOfNights);
            roomsToBook.add(rooms.get(roomIndex));
        }
        bookings.add(new Booking(totalPrice, roomsToBook, customers.get(customerIndex)));
        System.out.println("Booking was made successfully!");
    }

    public void checkIn(int customerIndex) {
        if (customerIndex == -1) {
            customerIndex = correctSSN();
        }
        int bookingID = 0;
        int bookingIndex = -1;
        while (bookingIndex == -1) {
            while (bookingID < 1) {
                System.out.println("Enter your bookingID");
                bookingID = Integer.parseInt(input.nextLine());
                if (bookingID < 1) {
                    System.out.println("You booking ID must be a positive number");
                }
            }
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getBookingId() == bookingID) {
                    bookingIndex = i;
                }
            }
            if (bookingIndex < 0) {
                System.out.println("The booking ID does not exist!");
                bookingID = 0;
            } else if (bookings.get(bookingIndex).getCustomer().getSocialSecurityNumber().equals(customers.get(customerIndex).getSocialSecurityNumber())) {
                System.out.println(bookings.get(bookingIndex));
                System.out.println("Is this the correct booking information? \n 1: Yes \n 2: No");
                int correct = Integer.parseInt(input.nextLine());
                switch (correct) {
                    case 1:
                        ArrayList<Room> roomsCheckIn = bookings.get(bookingIndex).getRooms();
                        for (int i = 0; i < roomsCheckIn.size(); i++) {
                            roomsCheckIn.get(i).setIsBooked(true);
                        }
                        System.out.println("Check in was made successfully!");
                        break;
                    case 2:
                        bookingIndex = -1;
                        bookingID = 0;
                        break;
                    default:
                        System.out.println("Invalid input, 1 or 2!");
                        break;
                }
            } else {
                System.out.println("The booking id and the customer does not match");
                bookingIndex = -1;
                bookingID = 0;
            }
        }
    }

    public void checkOut(int customerIndex) {
        if (customerIndex == -1) {
            customerIndex = correctSSN();
        }
        int bookingID = 0;
        int bookingIndex = -1;
        while (bookingIndex == -1) {
            while (bookingID < 1) {
                System.out.println("Enter your bookingID");
                bookingID = Integer.parseInt(input.nextLine());
                if (bookingID < 1) {
                    System.out.println("You booking ID must be a positive number");
                }
            }
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getBookingId() == bookingID) {
                    bookingIndex = i;
                }
            }
            if (bookingIndex < 0) {
                System.out.println("The booking ID does not exist!");
                bookingID = 0;
            } else if (bookings.get(bookingIndex).getCustomer().getSocialSecurityNumber().equals(customers.get(customerIndex).getSocialSecurityNumber())) {
                System.out.println(bookings.get(bookingIndex));
                System.out.println("Is this the correct booking information? \n 1: Yes \n 2: No");
                int correct = Integer.parseInt(input.nextLine());
                switch (correct) {
                    case 1:
                        ArrayList<Room> roomsCheckIn = bookings.get(bookingIndex).getRooms();
                        for (int i = 0; i < roomsCheckIn.size(); i++) {
                            roomsCheckIn.get(i).setIsBooked(false);
                        }
                        System.out.println("Check out was made successfully!");
                        break;
                    case 2:
                        bookingIndex = -1;
                        bookingID = 0;
                        break;
                    default:
                        System.out.println("Invalid input, 1 or 2!");
                        break;
                }
            } else {
                System.out.println("The booking id and the customer does not match");
                bookingIndex = -1;
                bookingID = 0;
            }
        }
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
            if (ssn.equals(String.valueOf(m))) {
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
            System.out.println("-----------------------------------------------");

            System.out.println("Enter the index of the booking you want to change: ");
            int index = Integer.parseInt(input.nextLine());

            System.out.println("------------ Current customer info ------------");
            System.out.println("BookingId " + bookings.get(index).getBookingId());
            System.out.println("Total price: " + bookings.get(index).getTotalPrice());
            System.out.println("-----------------------------------------------");

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


        System.out.print("Current social security number: " + customers.get(index).getSocialSecurityNumber()
                + "\nEnter a new social security number: ");
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
        int roomNumber = 0;
        boolean checkNumber = true;
        while (checkNumber) {
            while (roomNumber < 1) {
                System.out.print("Room number: ");
                roomNumber = Integer.parseInt(input.nextLine());
                if (roomNumber < 1) {
                    System.out.println("Room number must be a positive number!");
                }
            }
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getRoomNumber() == roomNumber) {
                    System.out.println("That room number already exists");
                    roomNumber = 0;
                }
            }
            if (roomNumber != 0) {
                checkNumber = false;
            }
        }
        int numberOfBeds = 0;
        while (numberOfBeds < 1) {
            System.out.print("Beds:  ");
            numberOfBeds = Integer.parseInt(input.nextLine());
            if (numberOfBeds < 1) {
                System.out.println("There must be minimum 1 bed");
            }
        }
        int balcony = 0;
        boolean hasBalcony = false;
        while (balcony < 1 || balcony > 2) {
            System.out.println("Does the room have a balcony \n 1: Yes \n 2: No");
            balcony = Integer.parseInt(input.nextLine());
            switch (balcony) {
                case 1:
                    hasBalcony = true;
                    break;
                case 2:
                    hasBalcony = false;
                    break;
                default:
                    System.out.println("Invalid input, 1 or 2");
            }
        }

        double pricePerNight = 0;
        while (pricePerNight < 1) {
            System.out.print("Price per night ");
            pricePerNight = Double.parseDouble(input.nextLine());
            if (pricePerNight < 1) {
                System.out.println("The price must be a positive number!");
            }
        }

        rooms.add(new Room(roomNumber, numberOfBeds, hasBalcony, pricePerNight, false));
        System.out.println("Room was successfully added!");
    }

    public void addCustomer() {
        String socialSecurityNumber = "";
        while (socialSecurityNumber.length() != 10) {
            System.out.println("Enter SSN: ");
            socialSecurityNumber = input.nextLine();
            if (socialSecurityNumber.length() != 10) {
                System.out.println("SSN should be in format (YYMMDDXXXX)");
            }
        }

        System.out.println("Enter Name: ");
        String name = input.nextLine();

        System.out.println("Enter Address: ");
        String address = input.nextLine();

        System.out.println("Enter Telephone Number: ");
        String telephoneNumber = input.nextLine();

        customers.add(new Customer(socialSecurityNumber, name, address, telephoneNumber));
        System.out.println("Customer was successfully added!");
    }

    public void viewAvailableRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getIsBooked() == false) {
                System.out.println(rooms.get(i));
            }
        }
    }

    public void editRoom() {
        boolean edit = true;
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println("Room [" + i + "] " + rooms.get(i));
        }
        int highestIndex = rooms.size() - 1;
        int index = -1;
        while (index < 0 || index > highestIndex) {
            System.out.println("Enter the index of the room you want to change: ");
            index = Integer.parseInt(input.nextLine());
            if (index < 0 || index > highestIndex) {
                System.out.println("The index must be between 0 and " + highestIndex + ".");
            }
        }
        System.out.println("Current Room info: " + rooms.get(index));

        while (edit) {
            System.out.println("edit \n 1: Room number \n 2: Number of beds \n 3: Balcony \n 4: Price per night \n 5: Exit ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    int roomNumber = 0;
                    boolean checkNumber = true;
                    while (checkNumber) {
                        while (roomNumber < 1) {
                            System.out.println("Current room number: " + rooms.get(index).getRoomNumber() + " New Room Number: ");
                            roomNumber = Integer.parseInt(input.nextLine());
                            if (roomNumber < 1) {
                                System.out.println("Room number must be a positive number!");
                            }
                        }
                        for (int i = 0; i < rooms.size(); i++) {
                            if (rooms.get(i).getRoomNumber() == roomNumber) {
                                System.out.println("That room number already exists");
                                roomNumber = 0;
                            }
                        }
                        if (roomNumber != 0) {
                            checkNumber = false;
                        }
                    }
                    rooms.get(index).setRoomNumber(roomNumber);
                    break;
                case 2:
                    int numberOfBeds = 0;
                    while (numberOfBeds < 1) {
                        System.out.println("Current number of beds: " + rooms.get(index).getNumberOfBeds() + " New number of beds: ");
                        numberOfBeds = Integer.parseInt(input.nextLine());
                        if (numberOfBeds < 1) {
                            System.out.println("There must be minimum 1 bed");
                        }
                    }
                    rooms.get(index).setNumberOfBeds(numberOfBeds);
                    break;
                case 3:
                    int balcony = 0;
                    boolean hasBalcony = false;
                    while (balcony < 1 || balcony > 2) {
                        System.out.println("Current Balcony status: " + rooms.get(index).getHasBalcony() + ", Does the room have a Balcony? " +
                                "\n 1: Yes \n 2: No");
                        balcony = Integer.parseInt(input.nextLine());
                        switch (balcony) {
                            case 1:
                                hasBalcony = true;
                                break;
                            case 2:
                                hasBalcony = false;
                                break;
                            default:
                                System.out.println("Invalid input, 1 or 2");
                        }
                    }
                    rooms.get(index).setHasBalcony(hasBalcony);
                    break;
                case 4:
                    double pricePerNight = 0;
                    while (pricePerNight < 1) {
                        System.out.println("Current Price per night: " + rooms.get(index).getPricePerNight() + " New price per night: ");
                        pricePerNight = Double.parseDouble(input.nextLine());
                        if (pricePerNight < 1) {
                            System.out.println("The price must be a positive number!");
                        }
                    }
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

    public void viewBookingHistory(int customerIndex) {
        if (customerIndex == -1) {
            customerIndex = correctSSN();
        }

        ArrayList<Booking> yourBookings = new ArrayList<>();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getCustomer() == customers.get(customerIndex)) {
                yourBookings.add(bookings.get(i));
            }
        }
        System.out.println(yourBookings);

    }

    public void editProfile(int customerIndex) {
        boolean editSSN = false;
        if (customerIndex == -1) {
            editSSN = true;
            customerIndex = correctSSN();
        }

        boolean exit = true;
        while (exit) {
            System.out.println("Edit - \n 1: SSN \n 2: Name \n 3: Address \n 4: Phone number \n 5: exit");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    if (editSSN) {
                        String SSN = "";
                        while (SSN.length() != 10) {
                            System.out.print("Current social security number: " + customers.get(customerIndex).getSocialSecurityNumber()
                                    + "\nEnter a new social security number: ");
                            SSN = input.nextLine();
                            if (SSN.length() != 10) {
                                System.out.println("SSN should be in format (YYMMDDXXXX)");
                            }
                        }
                        customers.get(customerIndex).setSocialSecurityNumber(SSN);
                    } else {
                        System.out.println("You are not allowed to change this, please contact the hotel employees.");
                    }
                    break;
                case 2:
                    System.out.print("Current name: " + customers.get(customerIndex).getName() + "\nNew name: ");
                    String name = input.nextLine();
                    customers.get(customerIndex).setName(name);
                    break;
                case 3:
                    System.out.print("Current address: " + customers.get(customerIndex).getAddress() + "\nEnter a new address: ");
                    String address = input.nextLine();
                    customers.get(customerIndex).setAddress(address);
                    break;
                case 4:
                    System.out.print("Current phone number: " + customers.get(customerIndex).getTelephoneNumber() + "\nEnter a new phone number: ");
                    String TelephoneNumber = input.nextLine();
                    customers.get(customerIndex).setTelephoneNumber(TelephoneNumber);
                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid input, 1-5");
                    break;
            }
        }
    }

    public int correctSSN() {
        int customerIndex = -1;
        while (customerIndex == -1) {
            String SSN = "";
            while (SSN.length() != 10) {
                System.out.println("Enter the SSN of the customer.");
                SSN = input.nextLine();
                if (SSN.length() != 10) {
                    System.out.println("SSN should be in format (YYMMDDXXXX)");
                }
            }

            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getSocialSecurityNumber().equals(SSN)) {
                    customerIndex = i;
                }
            }
            if (customerIndex == -1) {
                System.out.println("The customer does not exist!");
            }
        }
        return customerIndex;
    }

    public void cancelBooking(int customerIndex) {
        if (customerIndex == -1) {
            customerIndex = correctSSN();
        }
        int bookingID = 0;
        int bookingIndex = -1;
        while (bookingIndex < 0) {
            while (bookingID < 1) {
                System.out.println("Enter bookingID");
                bookingID = Integer.parseInt(input.nextLine());
                if (bookingID < 1) {
                    System.out.println("You booking ID must be a positive number");
                }
            }
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getBookingId() == bookingID) {
                    bookingIndex = i;
                }
            }
            if (bookingIndex < 0) {
                System.out.println("The booking ID does not exist!");
                bookingID = 0;
            } else if (bookings.get(bookingIndex).getCustomer() == customers.get(customerIndex)) {
                System.out.println(bookings.get(bookingIndex));
                System.out.println("Is this the correct booking information? \n 1: Yes \n 2: No");
                int correct = Integer.parseInt(input.nextLine());
                switch (correct) {
                    case 1:
                        bookings.remove(bookingIndex);
                        System.out.println("Booking was removed succesfully!");
                        break;
                    case 2:
                        bookingIndex = -1;
                        bookingID = 0;
                        break;
                    default:
                        System.out.println("Invalid input, 1 or 2!");
                        break;
                }
            }else {
                System.out.println("The booking id and the customer does not match");
                bookingIndex = -1;
                bookingID = 0;
            }
        }
    }

    public void printCustomerMenu() {
        System.out.println();
        System.out.println("1: View available rooms");
        System.out.println("------------------------------------------------");
        System.out.println("2: View booking history");
        System.out.println("------------------------------------------------");
        System.out.println("3: Make a new booking");
        System.out.println("------------------------------------------------");
        System.out.println("4: Edit your info");
        System.out.println("------------------------------------------------");
        System.out.println("5: Check in");
        System.out.println("------------------------------------------------");
        System.out.println("6: Check out");
        System.out.println("------------------------------------------------");
        System.out.println("7: Cancel booking");
        System.out.println("------------------------------------------------");
        System.out.println("8: Exit to log in menu");
        System.out.println("------------------------------------------------");
    }

    public void printEmployeeMenu() {
        System.out.println();
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
        System.out.println("16: Cancel booking.");
        System.out.println("------------------------------------------------");
        System.out.println("17: Exit to log in menu!");
        System.out.println("------------------------------------------------");
    }
}
