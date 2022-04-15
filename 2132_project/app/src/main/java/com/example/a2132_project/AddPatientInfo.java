package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddPatientInfo extends AppCompatActivity {

    private Button add_patient;
    private Button go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_info);

        /* set appointment activity */
        add_patient = (Button) findViewById(R.id.add_patient_info_btn);
        add_patient.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        // DATABASE HERE

                        Util.alert("Patient added.", AddPatientInfo.this);


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
}