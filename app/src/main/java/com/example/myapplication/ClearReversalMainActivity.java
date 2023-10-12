package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClearReversalMainActivity extends AppCompatActivity {

    String[] Host = {"Host1", "Host2"};
    String[] Merchant = {"SAMPATH", "AMEX"};
    AutoCompleteTextView autoCompleteTxtHost ,autoCompleteTxtMerchant;
    ArrayAdapter<String> adapterItems ,adapterItems2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_reversal_main);


        autoCompleteTxtHost = findViewById(R.id.autoCompleteTxtHost);
        autoCompleteTxtMerchant= findViewById(R.id.autoCompleteTxtMerchant);



        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, Host);
        autoCompleteTxtHost.setAdapter(adapterItems);

        autoCompleteTxtHost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });



        adapterItems2 = new ArrayAdapter<String>(this, R.layout.list_item, Merchant);
        autoCompleteTxtMerchant.setAdapter(adapterItems2);

        autoCompleteTxtMerchant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });




    }
}