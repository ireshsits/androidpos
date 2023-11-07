package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class CmvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmv);


        AppCompatButton btnProceedcomfirm = findViewById(R.id.btnProceedcomfirm);
        btnProceedcomfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CmvActivity.this, CManualEntryActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });
    }
}