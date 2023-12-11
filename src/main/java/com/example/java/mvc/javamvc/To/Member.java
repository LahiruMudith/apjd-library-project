package com.example.java.mvc.javamvc.To;

public class Member {
    private String id;
    private String name;
    private String email;
    private String address;
    private int ContactNumber;

    public Member(String id, String name, String email, String address, int contactNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.ContactNumber = contactNumber;
    }

    public Member() {

    }

    public Member(String id, String name, String email, String address, String contactNumber) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }
}
