package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);



        LinearLayout EditTableLinearLayout = findViewById(R.id.EditTableLinearLayout);
        EditTableLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetupActivity.this, EditTableActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


//        LinearLayout PinKeyInjectionLinearLayout = findViewById(R.id.PinKeyInjectionLinearLayout);
//        PinKeyInjectionLinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SetupActivity.this, PinKeyInjectionActivity.class); // Replace NewActivity with the name of your new activity class
//                startActivity(intent);
//            }
//        });




        LinearLayout SetMerchantLinearLayout = findViewById(R.id.SetMerchantLinearLayout);
        SetMerchantLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetupActivity.this, SetMerchantPasswordActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });

//



      LinearLayout TLEKeyDownloadLinearLayout = findViewById(R.id.TLEKeyDownloadLinearLayout);
        TLEKeyDownloadLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetupActivity.this, TleKeyDownloadActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout PinKeyInjectionLinearLayout = findViewById(R.id.PinKeyInjectionLinearLayout);
        PinKeyInjectionLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetupActivity.this, PinKeyInjectionActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });






    }
}