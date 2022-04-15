package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelfPatientAppointment extends AppCompatActivity {

    private Button set_self_appointment;
    private Button go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_patient_appointment);

        /* set_self_appointment */
        set_self_appointment = (Button) findViewById(R.id.self_appt_id);
        set_self_appointment.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        // DATABASE HERE

                        // user id
                        // date
                        // start time
                        // end time
                        // appointment type?


                        Util.alert("Appointment Set.", SelfPatientAppointment.this);
                    }
                }
        );

        /* go back to patient ui */
        go_back = (Button) findViewById(R.id.self_back_to_receptionist);
        go_back.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(SelfPatientAppointment.this, PatientActivity.class);
                        startActivity(signUp);
                    }
                }
        );

    }
}