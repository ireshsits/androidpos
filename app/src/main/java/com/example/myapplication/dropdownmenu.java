package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class dropdownmenu extends AppCompatActivity {


    String[] items = {"SAMPATH", "AMEX"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );

//        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
//
//        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);
//        autoCompleteTxt.setAdapter(adapterItems);
//
//        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(), "Item: " + item, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}


