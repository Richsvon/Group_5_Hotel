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

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber)    {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return  "\n SocialSecurityNumber: " + socialSecurityNumber +
                "\n Name: " + name +
                "\n Address: " + address +
                "\n Telephone number: " + telephoneNumber +
                "\n -------------------------------------";
    }
}

