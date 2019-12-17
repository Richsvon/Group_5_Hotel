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
        int customerIndex = -1;
        boolean checkExit = true;
        int choice;
        boolean employee = false;
        boolean customer = false;
        while (checkExit) {
            System.out.println("Log in as 1. employee or 2. customer or 3. for exit");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    boolean check = H.employeeLogIn();
                    if (check) {
                        employee = true;
                    }
                    break;
                case 2:
                    customerIndex = H.customerLogIn();
                    if(customerIndex !=-1){
                    customer = true;
                    }
                    break;
                case 3:
                    checkExit = false;
                    break;
                default:
                    System.out.println("invalid input, 1-3");
                    break;
            }//end userchoice
//----------------------------------------------------------------------------------------------------------------------
            while (employee) {
                customerIndex = -1;
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
                        H.makeBooking(customerIndex);
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
                        employee = false;
                        break;
                    default:
                        System.out.println("Invalid input, 1-16");
                        break;
                }//end switch
            }//end while employee
//----------------------------------------------------------------------------------------------------------------------
            while (customer) {
                H.printCustomerMenu();
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        H.viewAvailableRoomsByDate();
                        break;
                    case 2:
                        H.viewBookingHistory(customerIndex);
                        break;
                    case 3:
                        H.makeBooking(customerIndex);
                        break;
                    case 4:
                        H.editProfile(customerIndex);
                        break;
                    case 5:
                        customer = false;
                        break;
                    default:
                        System.out.println("invalid input, 1-5");
                        break;
                }//end switch
            }//end while customer
        }//end while checkExit
    }//end runProgram
}//end class