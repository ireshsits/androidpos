package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QrSettlementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_settlement);


        TextView btnCancelAmountScreen = findViewById(R.id.btnCancelAmountScreen);



        btnCancelAmountScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogUtils.showCustomAlertDialog(QrSettlementActivity.this, "Do you want to exit settlement?",MainActivity.class);
            }
        });








    }
}