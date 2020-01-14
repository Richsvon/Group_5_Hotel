package com.company;

import java.util.Scanner;

public class HotelApp {
    private Scanner input = new Scanner(System.in);
    private HotelLogic H = new HotelLogic();

    public static void main(String[] args) {
        HotelApp myApp = new HotelApp();
        myApp.runProgram();
    }

    public void runProgram() {
        H.addTestObjects();
        H.makeArrListToString();
        H.arrStringToTextFile();

        int customerIndex=-1;
        boolean checkExit = true;
        int choice;
        boolean employee = false;
        boolean customer = false;

        while (checkExit) {
            System.out.println("---- Hello and Welcome to our Hotel Application ----");
            System.out.println("------------------------------------------------");
            System.out.println("Log in as \n 1: Employee \n 2: Customer \n 3: Exit");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println();
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
                        H.checkIn(customerIndex);
                        break;
                    case 12:
                        H.checkOut(customerIndex);
                        break;
                    case 13:
                        H.viewBookingHistory(customerIndex);
                        break;
                    case 14:
                        H.editBooking();
                        break;
                    case 15:
                        H.editProfile(customerIndex);
                        break;
                    case 16:
                        H.cancelBooking(customerIndex);
                        break;
                    case 17:
                        employee = false;
                        break;
                    default:
                        System.out.println("Invalid input, 1-17");
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
                        H.viewAvailableRooms();
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
                        H.checkIn(customerIndex);
                        break;
                    case 6:
                        H.checkOut(customerIndex);
                        break;
                    case 7:
                        H.cancelBooking(customerIndex);
                        break;
                    case 8:
                        customer = false;
                        break;
                    default:
                        System.out.println("Invalid input, 1-8");
                        break;
                }//end switch
                H.arrStringToTextFile();
                H.textFileToArrString();
            }//end while customer
        }//end while checkExit
    }//end runProgram
}//end class
