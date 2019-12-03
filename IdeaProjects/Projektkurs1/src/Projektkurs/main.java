package Projektkurs;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        main myApp = new main();
        myApp.addCustomer();
    }
    public void addCustomer () {
        Scanner input = new Scanner(System.in);
        Customer Costumer = new Customer("", "", "", "");

        ArrayList<Customer> customers = new ArrayList<Customer>();
        System.out.println("Enter SSN ");
        String socialSecurityNumber = input.nextLine();

        System.out.println("Enter Name ");
        String name = input.nextLine();

        System.out.println("Enter address ");
        String address = input.nextLine();

        System.out.println("Enter telephone number ");
        String telephoneNumber = input.nextLine();

        customers.add(new Customer(socialSecurityNumber, name, address, telephoneNumber));

        // 90 min
    }
    public void viewCustomers(){

    }
}
