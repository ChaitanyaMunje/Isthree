package com.example.hp.isthree;

public class UserAddress {
    public String name,address,landmark,state,pincode,mobileno,altmobileno;

    public  UserAddress(){}

    public UserAddress(String name, String address, String landmark, String state, String pincode,String mobileno,String altmobileno) {
        this.mobileno=mobileno;
        this.altmobileno=altmobileno;
        this.name = name;
        this.address = address;
        this.landmark = landmark;
        this.state = state;
        this.pincode = pincode;
    }
}
