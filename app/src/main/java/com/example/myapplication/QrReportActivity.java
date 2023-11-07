package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class QrReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_report);




        LinearLayout AnyReceiptLinearLayout = findViewById(R.id.AnyReceiptLinearLayout);
        AnyReceiptLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrReportActivity.this, PrintAnyReceiptQRActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });




        LinearLayout QRHistoryLinearLayout = findViewById(R.id.QRHistoryLinearLayout);
        QRHistoryLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrReportActivity.this, QrHistoryActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });

    }
}