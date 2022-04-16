package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button receptionist_btn;
    private Button dentist_btn;
    private Button patient_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database db = new Database();

        /* receptionist activity */
        receptionist_btn = (Button) findViewById(R.id.receptionist_id);
        receptionist_btn.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    Intent signUp = new Intent(MainActivity.this, ReceptionistActivity.class);
                    startActivity(signUp);
                }
            }
        );

        /* dentist activity */
        dentist_btn = (Button) findViewById(R.id.dentist_id);
        dentist_btn.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    Intent signUp = new Intent(MainActivity.this, DentistActivity.class);
                    startActivity(signUp);
                }
            }
        );

        /* patient activity */
        patient_btn = (Button) findViewById(R.id.patient_id);
        patient_btn.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View v) {
                    Intent signUp = new Intent(MainActivity.this, PatientActivity.class);
                    startActivity(signUp);
                }
            }
        );
    }
}
