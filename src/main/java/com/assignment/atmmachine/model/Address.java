package com.assignment.atmmachine.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressid;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String county;
    private String country;
    private String zipcode;

    Address(String addressLineOne, String addressLineTwo, String city, String county, String country, String zip) {
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.county = county;
        this.country = country;
        this.zipcode = zip;
    }

    Address() {

    }
}
