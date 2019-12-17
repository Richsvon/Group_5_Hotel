package com.company;

import java.util.Scanner;

public class HotelApp {
    Scanner input = new Scanner(System.in);
    HotelLogic H = new HotelLogic();

    public static void main(String[] args) {
        HotelApp myApp = new HotelApp();
        myApp.runProgram();
    }

    public void runProgram() {
        H.addTestObjects();
        boolean checkExit = true;
        int choice;
        boolean employee = false;
        boolean customer = false;

        System.out.println("Log in as 1. employee or 2. customer or 3. for exit");
        choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                employee = true;
            case 2:
                customer = true;
            case 3:
                checkExit = false;
            default:
                System.out.println("invalid input, 1-3");
        }//end userchoice
//----------------------------------------------------------------------------------------------------------------------        
        while (checkExit) {
            while (employee) {
                H.employeeLogIn();
                H.printEmployeeMenu();
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        H.viewCustomers();
                        break;
                    case 2:
                        H.viewRooms();
                        break;
                    case 3:
                        H.viewAvailableRooms();
                        break;
                    case 4:
                        H.addRoom();
                        break;
                    case 5:
                        H.editRoom();
                        break;
                    case 6:
                        H.removeRoom();
                        break;
                    case 7:
                        H.addCustomer();
                        break;
                    case 8:
                        H.removeCustomer();
                        break;
                    case 9:
                        H.searchForBooking();
                        break;
                    case 10:
                        H.makeBooking();
                        break;
                    case 11:
                        //viewBooking is for testing purpose should. remove when necessary

                        H.checkIn();
                        break;
                    case 12:
                        H.checkOut();
                        break;
                    case 13:
                        H.viewCustomerHistory();
                        break;
                    case 14:
                        H.editBooking();
                        break;
                    case 15:
                        H.editCustomer();
                        break;
                    case 16:
                        checkExit = false;
                        break;
                }
            }
            switch (choice) {
                case 1:
                    H.viewCustomers();
                    break;
                case 2:
                    H.viewRooms();
                    break;
                case 3:
                    H.viewAvailableRooms();
                    break;
                case 4:
                    H.addRoom();
                    break;
                case 5:
                    H.editRoom();
                    break;
                case 6:
                    H.removeRoom();
                    break;
                case 7:
                    H.addCustomer();
                    break;
                case 8:
                    H.removeCustomer();
                    break;
                case 9:
                    H.searchForBooking();
                    break;
                case 10:
                    H.makeBooking();
                    break;
                case 11:
                    //viewBooking is for testing purpose should. remove when necessary
                    H.viewBookings();
                    H.checkIn();
                    break;
                case 12:
                    H.checkOut();
                    break;
                case 13:
                    H.viewCustomerHistory();
                    break;
                case 14:
                    H.editBooking();
                    break;
                case 15:
                    H.editCustomer();
                    break;
                case 16:
                    checkExit = false;
                    break;
            }//end switch
        }//end while employee
//----------------------------------------------------------------------------------------------------------------------
        while (customer) {
            int customerIndex = H.customerLogIn();
            H.printCustomerMenu();
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    H.viewAvailableRoomsByDate();
                    break;
                case 2:
                    H.viewBookingHistory();
                    break;
                case 3:
                    H.customerMakeBooking();
                    break;
                case 4:
                    H.editProfile();
                    break;
                case 5:
                    checkExit = false;
                default:
                    System.out.println("invalid input, 1-4");
                    break;
            }//end switch
        }//end while customer
    }//end while checkExit
}//end runProgram
