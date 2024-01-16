package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.harshana.wposandroiposapp.Base.WaitTimer;
import com.harshana.wposandroiposapp.DevArea.GlobalData;


public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_START_AMOUNT_INPUT = 1;
    public static final int REQUEST_START_AMOUNT_INPUT_QR = 3;
    public static final int REQUEST_START_MANUAL_KEY_IN = 2;
    private boolean isManual = false;
    private boolean cardInputTimerOff = false;
    public static TextView txtStatus;
    private ActivityResultLauncher<Intent> startAmountInputLauncher, startManualKeyIntentLauncher;


    GestureDetector gestureDetector;
    LinearLayout mainLayout;
    ImageView imageView4;

    ConstraintLayout tapcardconstraintlayout;
    LinearLayout mainmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tapcardconstraintlayout = findViewById(R.id.tapcardconstraintlayout);
        tapcardconstraintlayout.setVisibility(View.GONE);
        mainmenu = findViewById(R.id.mainmenu);
        mainmenu.setVisibility(View.VISIBLE);
        txtStatus = findViewById(R.id.txtStatus);
        mainLayout = findViewById(R.id.id_main_layout);
        imageView4 = findViewById(R.id.activityStatus);


        // ActivityResult For AmountInputLauncher
        startAmountInputLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {

                    //get amount from saleactivitiy
                    int amount = data.getIntExtra("amount", 0);


                    ToastMsg(Integer.toString(amount));

                    displayCardInputScreen();

                }
            }
        });

        // ActivityResult For ManualKeyIntentLauncher

        startManualKeyIntentLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                    int amount = data.getIntExtra("amount", 0);
                    Context context = getApplicationContext();
                    CharSequence text = "Input amount";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, Integer.toString(amount), duration);
                    toast.show();

                    displayCardInputScreen();

                }
            }
        });


        LinearLayout saleLinearLayout = findViewById(R.id.saleLinearLayout);
        saleLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaleActivity.class); // Replace NewActivity with the name of your new activity class
                startAmountInputLauncher.launch(intent);
            }
        });


        //        3.2. User Menu
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuUserActivity.class); // Replace NewActivity with the name of your new activity class

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
                amountInputQR.putExtra("merchenable", merchenable);
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

    public void displayCardInputScreen() {
        //load the required animation and play the audible clip to notify for requesting card input
        final View mainView = findViewById(R.id.id_main_layout);
        cardInputTimerOff = false;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                mainmenu.setVisibility(View.GONE);
                tapcardconstraintlayout.setVisibility(View.VISIBLE);
                tapcardconstraintlayout.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {

                            OntouchLisnerAction();
                            return true;  // Consume the event
                        }
                        return false;
                    }
                });


            }
        });

        final WaitTimer timer = new WaitTimer(10);
        timer.setOnTimeOutListener(new WaitTimer.OnTimeOutListener() {
            @Override
            public void onTimeOut() {
                GlobalData.globalTransactionAmount = 0;
                GlobalData.transactionCode = -1;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mainmenu.setVisibility(View.VISIBLE);
                        tapcardconstraintlayout.setVisibility(View.GONE);
                        ToastMsg("onTimeOut");
                    }
                });
                timer.stopTimer();
            }
        });


        timer.setOnTimerTickListener(new WaitTimer.OnTimerTickListener() {
            @Override
            public void onTimerTick(int tick) {

                //entered in a transaction
//                if (cardInputTimerOff || applicationBase.verifyTerminalAvailabilityForOperation()) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            ToastMsg("onTimerTick");
//                        }
//                    });
//                    timer.stopTimer();
//                }

            }
        });

        timer.start();
    }

    private void ToastMsg(String onTimerTick) {

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, onTimerTick, duration);
        toast.show();
    }

    private void OntouchLisnerAction() {

//
//        if(SettingsInterpreter.isManualKeyIn()) {
//                if(!isManual) {
//                    isManual = true;
//                    cardInputTimerOff = true;
//                    Sounds sounds = Sounds.getInstance();
//                    sounds.playCustSound(R.raw.tran_detect);
//                    //start the manual key entry screen
//                    applicationBase.setCardThreadStop(true);
//                    applicationBase.setInTransaction(true);
//                    try {
//                        if (applicationBase.bankCard != null)
//                            applicationBase.bankCard.breakOffCommand();
//                    } catch (Exception e) {
//                        isManual = false;
//                        e.printStackTrace();
//                    }
            Intent startManualKeyIntent = new Intent(MainActivity.this, CManualEntryActivity.class);
            startManualKeyIntentLauncher.launch(startManualKeyIntent);
//  }

        }

    }


