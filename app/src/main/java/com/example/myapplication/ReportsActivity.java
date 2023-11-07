 package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);





        LinearLayout HostLinearLayout = findViewById(R.id.HostLinearLayout);
        HostLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportsActivity.this, HostParametersActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });




        LinearLayout TRLinearLayout = findViewById(R.id.TRLinearLayout);
        TRLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportsActivity.this, TransactionReportActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });







        LinearLayout AnyReceiptLinearLayout = findViewById(R.id.AnyReceiptLinearLayout);
        AnyReceiptLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportsActivity.this, PrintAnyReceiptActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });



        LinearLayout LastReceiptLinearLayout = findViewById(R.id.LastReceiptLinearLayout);
        LastReceiptLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportsActivity.this, LastSettlementActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout LastSettlementLinearLayout = findViewById(R.id.LastSettlementLinearLayout);
        LastSettlementLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportsActivity.this, PrintLastSettkementsActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });





    }
}