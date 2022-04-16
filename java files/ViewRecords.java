package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewRecords extends AppCompatActivity {

    private Button back_to_home_dentist_records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        /* back to home page */
        back_to_home_dentist_records = (Button) findViewById(R.id.back_to_dentist_page);
        back_to_home_dentist_records.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(ViewRecords.this, DentistActivity.class);
                        startActivity(signUp);
                    }
                }
        );

    }
}