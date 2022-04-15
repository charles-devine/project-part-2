package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class PatientActivity extends AppCompatActivity {

    private Button back_to_login;
    private Button records_btn;
    private Button set_appointment;
    private Spinner user_id_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        // spinner

        // user_id_spinner

        // figure out how to get all patient names from database to display

        /* records */
        records_btn = (Button) findViewById(R.id.records_btn);
        records_btn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(PatientActivity.this, RecordsActivity.class);
                        startActivity(signUp);
                    }
                }
        );

        /* set_appointment */
        set_appointment = (Button) findViewById(R.id.set_appointments_for_patients_btn);
        set_appointment.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(PatientActivity.this, SelfPatientAppointment.class);
                        startActivity(signUp);
                    }
                }
        );

        /* back_to_login */
        back_to_login = (Button) findViewById(R.id.login_patient);
        back_to_login.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(PatientActivity.this, MainActivity.class);
                        startActivity(signUp);
                    }
                }
        );

    }
}