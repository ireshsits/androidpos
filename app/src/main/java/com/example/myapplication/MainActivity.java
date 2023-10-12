package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //        3.2. User Menu
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuUserActivity.class); // Replace NewActivity with the name of your new activity class

                startActivity(intent);
            }
        });



        LinearLayout saleLinearLayout = findViewById(R.id.saleLinearLayout);
        saleLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaleActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout voidLinearLayout = findViewById(R.id.voidLinearLayout);
        voidLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VoidActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout settlementLinearLayout = findViewById(R.id.settlementLinearLayout);
        settlementLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettlementActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout qrLinearLayout = findViewById(R.id.qrLinearLayout);
        qrLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QRActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });



        LinearLayout qrVerifyLinearLayout = findViewById(R.id.qrVerifyLinearLayout);
        qrVerifyLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QrVerifyActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });



        LinearLayout preAuthLinearLayout = findViewById(R.id.preAuthLinearLayout);
        preAuthLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreAuthActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });

        LinearLayout reportLinearLayout = findViewById(R.id.reportLinearLayout);
        reportLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReportsActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout setupLinearLayout = findViewById(R.id.setupLinearLayout);
        setupLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetupActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });






        LinearLayout settingsLinearLayout = findViewById(R.id.settingsLinearLayout);
        settingsLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });




        LinearLayout preCompLinearLayout = findViewById(R.id.preCompLinearLayout);
        preCompLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreCompletionActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout clearReversalLinearLayout = findViewById(R.id.clearReversalLinearLayout);
        clearReversalLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClearReversalMainActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });




        showCustomAlertDialog();















    }

    private void showCustomAlertDialog() {



        View customView =LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(customView);

        ImageView cancel = customView.findViewById(R.id.btnCancelTop);


        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}