package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PreCompletionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_completion);



        TextView btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                View customView = LayoutInflater.from(PreCompletionActivity.this).inflate(R.layout.pre_come_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(PreCompletionActivity.this);
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
                TextView btnQR = customView.findViewById(R.id.btnCancel);


                btnQR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PreCompletionActivity.this, MainActivity.class); // Replace NewActivity with the name of your new activity class
                        startActivity(intent);
                    }
                });





            }

        });

    }
 }