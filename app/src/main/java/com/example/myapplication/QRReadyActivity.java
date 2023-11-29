package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import net.glxn.qrgen.android.QRCode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class QRReadyActivity extends AppCompatActivity {


    public static  ImageView   qrImageView;
    private static SSLContext sslContext;
    private static boolean useCustCert = false;
    Bitmap lastQRBitMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_qrready2);


        qrImageView = findViewById(R.id.imgQRCode);
        prepareSSLContextForCustCert();
        generateQR();


    }

    private void generateQR() {
        new GenerateQRAsyncTask().execute();
    }

    private void prepareSSLContextForCustCert() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            InputStream inputStream = getClass().getResourceAsStream("/assets/sampath.crt");

            Certificate ca = certificateFactory.generateCertificate(inputStream);
            // Create a key store containing our ca
            String keystoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keystoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);

            // Create a trust manager which trusts the ca in our key store
            String tmfAlgo = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(tmfAlgo);
            trustManagerFactory.init(keyStore);
            // Create SSL context which uses our trust manager
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
            useCustCert = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private class GenerateQRAsyncTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            Log.d("QRGenerationResponse", "running");
            String response = "";
            try {
                String generateQRLink = "https://qrpos.sampath.lk/webservicesRest/api/lankaqr/v2/generateqr";
                String generateQRLinkLive = "https://posweb.sampath.lk/CapexServicesRest/api/lankaqr/v2/generateqr";
                String url = generateQRLink;

                JSONObject jsonRequest = createRequestJson();
                String auth_uat = "c2l0czplMDg2SVV0cWxqWUtrVXFXMStXRnp5ekE0NWxXTmlRczdOUHVCUWVoZER2bXlWVGxuQWx1RWNuUXR0WkorckFsRjVydDZ4QUlybUE4aXRZNWhUSFcvQkdIaS82UGFIYVc3eUhVeVFRaUVnYXlhZGNNdXVuUHNVMTNJS0djVllxQg==";
                // String auth_live = "QZUZc8gHufu5I28Vt8rwPcQEevXBlDBTxxH+KH1Qx96ZlP2auNs/bXuZKgW+Q1V63K6SS3GQ9ZkOn3qWNWpn9FZlc09ojDP4J9ZP3ZbLWrsJqmjuN4CzpFfuOEJtx9Nn";
                String auth = "sits:e086IUtqljYKkUqW1+WFzyzA45lWNiQs7NPuBQehdDvmyVTlnAluEcnQttZJ+rAlF5rt6xAIrmA8itY5hTHW/BGHi/6PaHaW7yHUyQQiEgayadcMuunPsU13IKGcVYqB";
                auth = Base64.encodeToString(auth_uat.getBytes("utf-8"), Base64.DEFAULT);

                URL downloadLink = new URL(url);
                HttpsURLConnection urlConnection = (HttpsURLConnection) downloadLink.openConnection();


                if (useCustCert) {
                    prepareSSLContextForCustCert(); // Call the SSL setup method
                    if (sslContext != null) {
                        if (urlConnection instanceof HttpsURLConnection) {
                            ((HttpsURLConnection) urlConnection).setSSLSocketFactory(sslContext.getSocketFactory());
                        }
                    }
                }


                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("ServiceName", "GenerateQR_V2");
                urlConnection.setRequestProperty("TokenID", "0");

                urlConnection.setRequestProperty("Authorization", "Basic " + auth_uat);
                urlConnection.setConnectTimeout(10 * 6000);
                urlConnection.setReadTimeout(10 * 6000);
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setChunkedStreamingMode(0);

                Date now = new Date();
                String format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH).format(now);

                OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                BufferedWriter writer = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    writer = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));

                }


                Log.d("jsonRequest", jsonRequest.toString());
                writer.write(jsonRequest.toString());
                writer.flush();

                InputStream inputStream = null;
                int respCode = urlConnection.getResponseCode();

                Log.d("respCode", String.valueOf(respCode));

                if (respCode != HttpURLConnection.HTTP_OK) {
                    response = "Error: " + urlConnection.getResponseMessage();
                    return response;
                }

                inputStream = urlConnection.getInputStream();

                int readLen = 0;
                byte[] readBuffer = new byte[1024];
                StringBuilder str = new StringBuilder();

                while ((readLen = inputStream.read(readBuffer)) != -1) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        str.append(new String(readBuffer, 0, readLen, StandardCharsets.UTF_8));
                    }
                }

                String jsonResponse = str.toString();
                String qrCode = "";
                String errCode = "";

                try {
                    JSONObject jsonObject = new JSONObject(jsonResponse);
                    errCode = jsonObject.getString("RESP_CODE");
                    if (errCode.equals("00")) qrCode = jsonObject.getString("QR_CODE");
                    else qrCode = jsonObject.getString("RESP_DESC");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                Log.d("qrCodeResponse", qrCode);

                inputStream.close();
                urlConnection.disconnect();

                if (!errCode.equals("00") || qrCode.isEmpty())
                    response = qrCode + " Error: " + errCode;
                else response = qrCode;

            } catch (Exception ex) {
                response = "ErrorEx: " + ex.getMessage();
                ex.printStackTrace();
            }

            return response;
        }


        @Override
        protected void onPostExecute(String result) {
            Log.d("QRGenerationResponse", result);

            DisplayQr(result);


        }


    }

    private void DisplayQr(String result) {

        Bitmap myBitmap = QRCode.from("result").withSize(400, 400).bitmap();
        qrImageView.setImageBitmap(myBitmap);

    }


    private static JSONObject createRequestJson() throws JSONException {
        JSONObject trxMessage = new JSONObject();
        JSONObject message = new JSONObject();
        JSONObject trxMsg = new JSONObject();
        JSONObject deviceData = new JSONObject();
        JSONArray deviceDataArray = new JSONArray();
        JSONObject xmlmsg = new JSONObject();


        String dtTime = getDateTimeFormatted();
        trxMessage.put("RequestTime", dtTime);
        trxMessage.put("hostname", "192.168.129.65");
        trxMessage.put("port", "1220");
        trxMessage.put("RequestID", "CCARD_123456780");


        message.put("MID", "1627800000000000030050060000");
        message.put("TX_AMT", "12.00");
        message.put("PAYMENT_TYPE", "1");
        message.put("MERC_NAME", "WPOS QR-SUNTECH");
        message.put("MERC_CITY", "COLOMBO");
        message.put("OPT_MERC", "0");
        message.put("TX_STATUS", "09");
        message.put("REF_LABEL", dtTime);
        message.put("TX_TYPE", "0");
        message.put("QR_TYPE", "0");
        message.put("MESSAGE_ID", "emvco_generate_qr");
        message.put("TX_CURRENCY", "144");
        message.put("POSTAL_CODE", "0000");
        message.put("COUNTRY_CODE", "LK");
        message.put("RequestTime", dtTime);
        message.put("BILL_DATA", "0");
        message.put("MCC", "4814");
        message.put("TX_ORG", "SMB_POS");


        trxMsg.put("MESSAGE", message);
        trxMessage.put("xmlmsg", xmlmsg);
        xmlmsg.put("TRX_MESSAGE", trxMsg);


        // Add "DeviceData" objects to the array
        JSONObject deviceData1 = new JSONObject();
        deviceData1.put("PropertyName", "AndroidVersion");
        deviceData1.put("PropertyValue", "5.1");

        JSONObject deviceData2 = new JSONObject();
        deviceData2.put("PropertyName", "Immi");
        deviceData2.put("PropertyValue", "867250030132883");

        deviceDataArray.put(deviceData1);
        deviceDataArray.put(deviceData2);

        trxMessage.put("DeviceData", deviceDataArray);


        return trxMessage;
    }

    private static String getDateTimeFormatted() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(new Date());

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String strTime = timeFormat.format(new Date());

        String dt = strDate + "T" + strTime + ".511Z";
        // String dt = strDate + "T" + strTime + ".511Z";
        return dt;
    }

}
