package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetPatientAppointment extends AppCompatActivity {

    private Button set_appointment;
    private Button go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_patient_appointment);

        /* set appointment activity */
        set_appointment = (Button) findViewById(R.id.set_appointment_id);
        set_appointment.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        // DATABASE HERE

                        Util.alert("Appointment Set.", SetPatientAppointment.this);



                    }
                }
        );

        /* set appointment activity */
        go_back = (Button) findViewById(R.id.back_to_receptionist);
        go_back.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(SetPatientAppointment.this, ReceptionistActivity.class);
                        startActivity(signUp);
                    }
                }
        );

    }
}