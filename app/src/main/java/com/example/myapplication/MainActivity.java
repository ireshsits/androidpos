package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    public static final int REQUEST_START_AMOUNT_INPUT_QR = 3;
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


                    View customView = LayoutInflater.from(MainActivity.this).inflate(R.layout.settlement_dialog, null);
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
                TextView btnQR = customView.findViewById(R.id.btnQR);
                TextView btnSale = customView.findViewById(R.id.btnSale);

                btnQR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, QrSettlementActivity.class); // Replace NewActivity with the name of your new activity class
                        startActivity(intent);
                    }
                });

                btnSale.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SettlementActivity.class); // Replace NewActivity with the name of your new activity class
                        startActivity(intent);
                    }
                });



//                Intent intent = new Intent(MainActivity.this, SettlementActivity.class); // Replace NewActivity with the name of your new activity class
//                startActivity(intent);
            }
        });


        LinearLayout qrLinearLayout = findViewById(R.id.qrLinearLayout);
        qrLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                if(applicationBase.checkForQRTran()) {
//                    showToast("Pending QR Tran Available");
//                }
//                else {
                    boolean merchenable = false;
                    Intent amountInputQR = new Intent(MainActivity.this, InputAmount.class);
                    amountInputQR.putExtra("merchenable",merchenable);
                   startActivity(amountInputQR);
                    //startActivityForResult(amountInputQR, REQUEST_START_AMOUNT_INPUT_QR);
//                }


            }
        });



//        LinearLayout qrVerifyLinearLayout = findViewById(R.id.qrVerifyLinearLayout);
//        qrVerifyLinearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, QrVerifyActivity.class); // Replace NewActivity with the name of your new activity class
//                startActivity(intent);
//            }
//        });

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


        LinearLayout clearBatchLinearLayout = findViewById(R.id.clearBatchLinearLayout);
        clearBatchLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ClearBatchActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


        LinearLayout forceReversalLinearLayou = findViewById(R.id.forceReversalLinearLayout);
        clearBatchLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForceReversalActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });

        LinearLayout qrreportLinearLayout = findViewById(R.id.qrreportLinearLayout);
        qrreportLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QrReportActivity.class); // Replace NewActivity with the name of your new activity class
                startActivity(intent);
            }
        });


    }


}