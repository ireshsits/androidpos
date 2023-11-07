package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class select_merchant_Activity extends AppCompatActivity {

    String[] items = {"SAMPATH", "AMEX"};
    AutoCompleteTextView autoCompleteTxt_Mercant,autoCompleteTxt_Host;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_merchant);

        autoCompleteTxt_Mercant = findViewById(R.id.auto_complete_txt_Mercant);
        autoCompleteTxt_Host = findViewById(R.id.auto_complete_txt_host);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);
        autoCompleteTxt_Mercant.setAdapter(adapterItems);
        autoCompleteTxt_Host.setAdapter(adapterItems);

        autoCompleteTxt_Mercant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),   "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteTxt_Host.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),   "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });


        TextView btnProceedAmountScreen =findViewById(R.id.btnProceedAmountScreen);
        btnProceedAmountScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(select_merchant_Activity.this, TapScreenActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        TextView btnCancelAmountScreen =findViewById(R.id.btnCancelAmountScreen);
        btnCancelAmountScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialogUtils.showCustomAlertDialog(select_merchant_Activity.this, "Do you really want to cancel selection?",MainActivity.class);

            }
        });




    }

}