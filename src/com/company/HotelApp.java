package com.company;

import java.util.Scanner;

public class    HotelApp {
    Scanner input = new Scanner(System.in);
    HotelLogic H = new HotelLogic();

    public static void main(String[] args) {
        HotelApp myApp = new HotelApp();
        myApp.runProgram();

    }

    public void runProgram() {
        H.addTestObjects();
        boolean checkExit = true;
        boolean checkInput = true;
        int choice = 0;
        while (checkExit) {
            printMenu();
            while (checkInput) {
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(input.nextLine());
                if (choice < 1 || choice > 17) {
                    System.out.println("Invalid input, please enter a number 1-17.");
                } else {
                    checkInput = false;
                }
            }
            checkInput = true;
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
            }
        }
    }

    public void printMenu() {
        System.out.println("---- Hello and Welcome to our Hotel Application ----");
        System.out.println();
        System.out.println("Please select one of the options.");
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
        System.out.println("16: Exit!");
        System.out.println("------------------------------------------------");
    }
}
