package com.assignment.atmmachine.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Contact {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactid;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @OneToOne @JoinColumn(name="addressid")
    private Address primaryAddress;
    private Date birthDate;

    Contact(String firstName, String lastName, String phoneNumber, Date dob, Address addr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = dob;
        this.primaryAddress = addr;
    }

    Contact() {

    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getContactid() {
        return contactid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String DisplayName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
