package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PreCompletionActivity extends AppCompatActivity {

    EditText txtInvoice;

    String selectedMerchant =null;
    String selectedHost=null;
    TextView txtDesc,txtDesc2,btnConfirm;
    AutoCompleteTextView autoCompleteTxt_Mercant, autoCompleteTxt_Host;
    ArrayAdapter<String> HostadapterItems, MercantadapterItems;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_completion);

        autoCompleteTxt_Mercant = findViewById(R.id.auto_complete_txt_Mercant);
        autoCompleteTxt_Host = findViewById(R.id.auto_complete_txt_host);
        context = this;
        txtInvoice = findViewById(R.id.txtInvoiceNumber);
       btnConfirm = findViewById(R.id.btnConfirm);



        btnConfirmDisabled();
      //  btnConfirmEnabled();




        Typeface tp = Typeface.createFromAsset(getAssets(),"digital_font.ttf");
        txtInvoice.setTypeface(tp);

        txtInvoice.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(selectedMerchant==null || selectedHost==null  )
                {
                    showToast("Please select a merchant to proceed");
                }

                return false;
            }
        });


        txtDesc = findViewById(R.id.txtDesc);
        txtDesc2 = findViewById(R.id.txtDesc2);
        txtDesc2.setTypeface(tp);
        txtDesc.setTypeface(tp);











        autoCompleteTxt_Mercant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "selected Merchant : " + item, Toast.LENGTH_SHORT).show();
                selectedMerchant=item;
            }
        });
        autoCompleteTxt_Host.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Host : " + item, Toast.LENGTH_SHORT).show();
                selectedHost=item;
            }
        });



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










        loadMerchants();
        loadHost();


    }

    private void btnConfirmDisabled() {


        btnConfirm.setEnabled(false);
        btnConfirm.setAlpha(0.2f);
    }

    private void btnConfirmEnabled() {
        btnConfirm.setEnabled(true);
        btnConfirm.setAlpha(1);

    }


    Toast showToastMessage;
    void showToast(String toastMessage) {
        if (showToastMessage != null) {
            showToastMessage.setText(toastMessage);
            showToastMessage.show();
        } else {
            showToastMessage = Toast.makeText(PreCompletionActivity.this,toastMessage,Toast.LENGTH_SHORT);
            showToastMessage.show();
        }
    }



    private void loadHost() {
        String[] Hostitems = {"Host1", "Host2"};

        HostadapterItems = new ArrayAdapter<String>(this, R.layout.list_item, Hostitems);
        autoCompleteTxt_Host.setAdapter(HostadapterItems);
    }

    private void loadMerchants() {
        String[] Mercantitems = {"SAMPATH", "AMEX"};
        MercantadapterItems = new ArrayAdapter<String>(this, R.layout.list_item, Mercantitems);
        autoCompleteTxt_Mercant.setAdapter(MercantadapterItems);
    }
}