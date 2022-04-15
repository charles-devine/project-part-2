package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class ReceptionistActivity extends AppCompatActivity {

    private Button back_to_login;
    private Button edit_btn;
    private Button add_patient_btn;
    private Button appt_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist);

        /* back_to_login */
        back_to_login = (Button) findViewById(R.id.login_receptionist);
        back_to_login.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(ReceptionistActivity.this, MainActivity.class);
                        startActivity(signUp);
                    }
                }
        );

        /* set appointment activity */
        appt_btn = (Button) findViewById(R.id.set_patient_appointment);
        appt_btn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(ReceptionistActivity.this, SetPatientAppointment.class);
                        startActivity(signUp);
                    }
                }
        );

        /* set appointment activity */
        add_patient_btn = (Button) findViewById(R.id.add_patient);
        add_patient_btn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(ReceptionistActivity.this, AddPatientInfo.class);
                        startActivity(signUp);
                    }
                }
        );
    }


}