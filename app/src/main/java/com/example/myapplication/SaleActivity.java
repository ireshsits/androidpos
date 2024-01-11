package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_amount);



        // btnCancelAmountScreen
        TextView btnCancelAmountScreen = findViewById(R.id.btnCancelAmountScreen);

        btnCancelAmountScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaleActivity.this, MainActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });




      //btnProceedAmountScreen   3.1.1. sale 2
        TextView btnProceedAmountScreen = findViewById(R.id.btnProceedAmountScreen);

        btnProceedAmountScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("amount", 100);
                setResult(Activity.RESULT_OK, resultIntent);

                // Finish the activity
                finish();


//                Intent intent = new Intent(SaleActivity.this, select_merchant_Activity.class); // Replace NewActivity with the name of your new activity class
//                startActivity(intent);
            }
        });










    }
}