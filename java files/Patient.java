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
    private int ssn;
    private String gender;
    private String email;
    private String dateOfBirth;
    private boolean insurance;

    public Patient(
        String firstName,
        String middleName,
        String lastName,
        int houseNumber,
        String street,
        String city,
        String province,
        String password,
        int ssn,
        String gender,
        String email,
        String dateOfBirth,
        boolean insurance
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

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPassword() {
        return password;
    }

    public int getSsn() {
        return ssn;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getInsurance() {
        return insurance;
    }
}
