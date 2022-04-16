package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DentistActivity extends AppCompatActivity {

    private Button back_to_home_dentist;
    private Button view_records;
    private Spinner patient_list;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist);

        // spinner

        /* view records */
        view_records = (Button) findViewById(R.id.view_patient_information);
        view_records.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(DentistActivity.this, ViewRecords.class);
                        startActivity(signUp);
                    }
                }
        );

        /* back to home page */
        back_to_home_dentist = (Button) findViewById(R.id.back_to_home_page_dentist);
        back_to_home_dentist.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(DentistActivity.this, MainActivity.class);
                        startActivity(signUp);
                    }
                }
        );

    }
}