package com.example.a2132_project;

public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;
    private int houseNumber;
    private String street;
    private String city;
    private String province;
    private String password;
    private String ssn;
    private String gender;
    private String email;
    private String dateOfBirth;
    private String insurance;

    public Patient(
        String firstName,
        String middleName,
        String lastName,
        int houseNumber,
        String street,
        String city,
        String province,
        String password,
        String ssn,
        String gender,
        String email,
        String dateOfBirth,
        String insurance
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.province = province;
        this.password = password;
        this.ssn = ssn;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.insurance = insurance;
    }
}
