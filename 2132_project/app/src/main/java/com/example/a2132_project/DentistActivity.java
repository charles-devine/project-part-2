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

        patient_list = (Spinner) findViewById(R.id.pat_spinner_id);
        ArrayList<String> patient_id_list = new ArrayList<>();

        Database db = new Database();

        try {
            Connection conn = db.getExtraConnection();
            Statement stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery(
                    "SELECT user_id " +
                            "FROM Patient ");

            while (rset.next()) {
                int uid = rset.getInt("user_id");
                // do whatever you need to do to put the uid values into the scroll wheel?
                patient_id_list.add(((Integer) uid).toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DentistActivity.this, android.R.layout.simple_spinner_item, patient_id_list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patient_list.setAdapter(adapter);
        patient_list.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        user_id = patient_list.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                }
        );

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