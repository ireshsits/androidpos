package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.QRIntegration.QRCoreLogic;
import com.harshana.wposandroiposapp.Base.QRTran;

import net.glxn.qrgen.android.QRCode;

import org.json.JSONObject;

import javax.net.ssl.SSLContext;

public class QRReadyActivity extends AppCompatActivity {

    QRCoreLogic qrCoreLogic = null;
    public static ImageView qrImageView, qrStatusImageView;
    private static SSLContext sslContext;
    private static boolean useCustCert = false;
    Bitmap lastQRBitMap = null;
    ProgressBar progressBar;
    public QRTran qrTran;


    final static String STATUS_COMPLETE = "01";
    final static String STATUS_FAILED = "05";
    final static String STATUS_INCOMPLETE = "09";

    TextView statustextView, btnCancel;

    private Handler handler = new Handler();
    private Runnable runnableCode;
    private int totalDuration = 60 * 60 * 1000; // 1 hour in milliseconds
    private int elapsedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_qrready2);
        qrImageView = findViewById(R.id.imgQRCode);
        qrStatusImageView = findViewById(R.id.qrStatusImageView);
        progressBar = findViewById(R.id.progressBar);
        statustextView = findViewById(R.id.statustextView);
        btnCancel = findViewById(R.id.btnCancel);
        showProgressBar(true);


        qrCoreLogic = QRCoreLogic.getInstance();
        qrCoreLogic.prepareSSLContextForCustCert();
        qrCoreLogic.initQRCode();


        qrCoreLogic.setQRResultListener(new QRCoreLogic.QRResultListener() {
            @Override
            public void onQRResultReceived(String result, boolean qrcode_status) {
                // Perform actions in the main class with the result received from the subclass

                showProgressBar(false);
                if (qrcode_status) {
                    qrStatusImageView.setImageResource(R.drawable.ready);
                    Log.d("QRGenerationResponse", result);
                    Bitmap myBitmap = QRCode.from(result).withSize(550, 550).bitmap();
                    qrImageView.setImageBitmap(myBitmap);


                    //RUNCODE IN LOOP
                    startRepeatingTask();
                    qrCoreLogic.validateCode();


                } else {
                    qrStatusImageView.setImageResource(R.drawable.failed);
                    qrImageView.setImageResource(R.drawable.testerrorqr);
                }

            }
        });


        qrCoreLogic.setQRValidatListener(new QRCoreLogic.QRValidatListener() {

            @Override
            public void onQRValidatReceived(String response) {
                decodeResponse(response);
                Log.d("QRGValidatResponse", "qrTran status:-" + qrTran.status);


                String status = qrTran.status;

                if (status == "" || status == "null" || status == "05") {
                    updateStatusText("Failed to receive.");
                } else if (status == "9") {
                    updateStatusText("Retrying");
                } else if (status == "1") {
                    updateStatusText("Completed");
                    stopRepeatingTask();
                }


            }
        });


    }

    private void updateStatusText(String text) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                statustextView.setText(text);
            }
        });


    }

    private void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }


    private int decodeResponse(String response) {
        qrTran = new QRTran();

        try {
            JSONObject jsonObject = new JSONObject(response);
            qrTran.status = jsonObject.getString("TX_STATUS");


            if (qrTran.status.equals(STATUS_COMPLETE)) {
                qrTran.mid = jsonObject.getString("MID");
                qrTran.merchName = jsonObject.getString("MERC_NAME");
                qrTran.merchCity = jsonObject.getString("MERC_CITY");
                qrTran.terminalID = jsonObject.getString("TerminlaId");
                qrTran.MCC = jsonObject.getString("MCC");
                qrTran.cusMobile = jsonObject.getString("MOBILE_NUMBER");
                qrTran.cardHolder = jsonObject.getString("CRD_HLDR");
                qrTran.PAN = jsonObject.getString("FRM_CRD");
                qrTran.trace = jsonObject.getString("TRACE");
                //qrTran.refQRLabel = jsonObject.getString("REF_LABEL");
                qrTran.txOrg = jsonObject.getString("TX_ORG");
                if (jsonObject.getInt("QR_TYPE") == 0) {
                    qrTran.qrType = "DYNAMIC";
                } else {
                    qrTran.qrType = "STATIC";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }


    public void startRepeatingTask() {
        runnableCode = new Runnable() {
            @Override
            public void run() {
                // Place the code you want to execute here
                // This will run every 2 minutes
                runevery();
                elapsedTime += 2 * 60 * 1000; // Add 2 minutes to elapsed time

                if (elapsedTime < totalDuration) {
                    // Schedule the same runnable to run again in 2 minutes
                    handler.postDelayed(this, 2 * 60 * 1000); // 2 minutes in milliseconds
                }
            }
        };

        // Start the initial runnable task by posting it to the handler
        handler.post(runnableCode);
    }

    private void runevery() {
        qrCoreLogic.validateCode();


    }


    public void stopRepeatingTask() {
        // Remove any pending posts of the runnable from the handler
        handler.removeCallbacks(runnableCode);
        elapsedTime = 0; // Reset elapsed time
    }

}
