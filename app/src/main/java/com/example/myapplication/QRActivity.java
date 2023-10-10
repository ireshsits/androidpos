package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);




        TextView btnProceedAmountScreen = findViewById(R.id.btnProceedAmountScreen);
        btnProceedAmountScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QRActivity.this, QRReadyActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });



    }
}