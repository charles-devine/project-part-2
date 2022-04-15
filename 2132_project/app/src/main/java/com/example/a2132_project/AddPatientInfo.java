package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddPatientInfo extends AppCompatActivity {

    private Button add_patient;
    private Button go_back;

    private EditText firstNameField, middleNameField, lastNameField, houseNumberField, streetField, cityField, provinceField, passwordField, ssnField, genderField, emailField, dateOfBirthField;
    private ToggleButton insuranceField;
    private String firstName, middleName, lastName, street, city, province, password, gender, email, dateOfBirth;
    private int houseNumber, ssn;
    private boolean insurance;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_info);

        firstNameField = findViewById(R.id.firstName_field);
        middleNameField = findViewById(R.id.middleName_field);
        lastNameField = findViewById(R.id.lastName_field);
        houseNumberField = findViewById(R.id.houseNo_field);
        streetField = findViewById(R.id.street_field);
        cityField = findViewById(R.id.city_field);
        provinceField = findViewById(R.id.province_field);
        passwordField = findViewById(R.id.password_field);
        ssnField = findViewById(R.id.ssn_field);
        genderField = findViewById(R.id.gender_field);
        emailField = findViewById(R.id.email_field);
        dateOfBirthField = findViewById(R.id.dob_field);
        insuranceField = (ToggleButton) findViewById(R.id.insurance_field);

        /* set appointment activity */
        add_patient = (Button) findViewById(R.id.add_patient_info_btn);
        add_patient.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    Database db = new Database();
                    validateCredentials();
                    Patient patient = new Patient(
                        firstName,
                        middleName,
                        lastName,
                        houseNumber,
                        street,
                        city,
                        province,
                        password,
                        ssn,
                        gender,
                        email,
                        dateOfBirth,
                        insurance
                    );
                    String SQLQuery = "INSERT INTO local.patient (user_id,first_name,middle_name,last_name,house_number,street,city,province,password,ssn,gender,email,date_of_birth,insurance) "
                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    long id = 0;
                    try (Connection manager = db.getExtraConnection();
                         PreparedStatement pstmt = manager.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS)) {
                        pstmt.setString(1, patient.getFirstName());
                        pstmt.setString(2, patient.getMiddleName());
                        pstmt.setString(3, patient.getLastName());
                        pstmt.setString(4, String.valueOf(patient.getHouseNumber()));
                        pstmt.setString(5, patient.getStreet());
                        pstmt.setString(6, patient.getCity());
                        pstmt.setString(7, patient.getProvince());
                        pstmt.setString(8, patient.getPassword());
                        pstmt.setString(9, String.valueOf(patient.getSsn()));
                        pstmt.setString(10, patient.getGender());
                        pstmt.setString(11, patient.getEmail());
                        pstmt.setString(12, patient.getDateOfBirth());
                        pstmt.setString(13, String.valueOf(patient.getInsurance()));

                        int affectedRows = pstmt.executeUpdate();
                        if (affectedRows > 0) {
                            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                                if (rs.next()) {
                                    id = rs.getLong(1);
                                }
                            } catch (SQLException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    } catch (SQLException e) {
                        Util.alert(e.getMessage(), AddPatientInfo.this);
                    }
//                    Util.alert("Patient added.", AddPatientInfo.this);
                }
            }
        );

        /* set appointment activity */
        go_back = (Button) findViewById(R.id.back_to_receptionist_add);
        go_back.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    Intent signUp = new Intent(AddPatientInfo.this, ReceptionistActivity.class);
                    startActivity(signUp);
                }
            }
        );
    }

    private boolean validateCredentials() {
        firstName = firstNameField.getText().toString();
        if (firstName.length() == 0) {
            Util.alert("Invalid first name", AddPatientInfo.this);
            return false;
        }

        lastName = lastNameField.getText().toString();
        if (lastName.length() == 0) {
            Util.alert("Invalid last name", AddPatientInfo.this);
            return false;
        }

        try {
            houseNumber = Integer.parseInt(houseNumberField.getText().toString());
        } catch (Exception e) {
            Util.alert("Invalid house number:\n" + e.getMessage(), AddPatientInfo.this);
            return false;
        }

        street = streetField.getText().toString();
        if (street.length() == 0) {
            Util.alert("Invalid street number", AddPatientInfo.this);
            return false;
        }

        city = cityField.getText().toString();
        if (city.length() == 0) {
            Util.alert("Invalid city", AddPatientInfo.this);
            return false;
        }

        province = provinceField.getText().toString();
        if (province.length() == 0) {
            Util.alert("Invalid province", AddPatientInfo.this);
            return false;
        }

        password = passwordField.getText().toString();
        if (password.length() == 0) {
            Util.alert("Invalid password", AddPatientInfo.this);
            return false;
        }

        try {
            ssn = Integer.parseInt(ssnField.getText().toString());
        } catch (Exception e) {
            Util.alert("Invalid ssn", AddPatientInfo.this);
            return false;
        }

        gender = genderField.getText().toString();
        if (gender.length() == 0) {
            Util.alert("Invalid gender", AddPatientInfo.this);
            return false;
        }

        email = emailField.getText().toString();
        if (email.length() == 0) {
            Util.alert("Invalid email", AddPatientInfo.this);
            return false;
        }

        dateOfBirth = dateOfBirthField.getText().toString();
        if (dateOfBirth.length() == 0 && !dateOfBirth.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
            Util.alert("Invalid date of birth", AddPatientInfo.this);
            return false;
        }

        insurance = insuranceField.isChecked();

        return true;
    }
}
