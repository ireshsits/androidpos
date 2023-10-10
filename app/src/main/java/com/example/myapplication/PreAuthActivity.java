package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreAuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_auth);


        TextView qrVerifyLinearLayout = findViewById(R.id.btnProceedAmountScreen);
        qrVerifyLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreAuthActivity.this, SettlementActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });
    }
}