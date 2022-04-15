package com.example.a2132_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecordsActivity extends AppCompatActivity {

    private Button go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        // load medical history

        // load upcoming appts

        /* go back to patient ui */
        go_back = (Button) findViewById(R.id.records_loging_btn);
        go_back.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent signUp = new Intent(RecordsActivity.this, PatientActivity.class);
                        startActivity(signUp);
                    }
                }
        );

    }
}