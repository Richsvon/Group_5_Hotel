package com.company;

public class Customer {
    private String socialSecurityNumber;
    private String name;
    private String address;
    private String telephoneNumber;

    public Customer(String socialSecurityNumber, String name, String address, String telephoneNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}

