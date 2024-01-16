package com.example.myapplication;


        import android.os.Bundle;
        import android.view.View;
        import android.widget.NumberPicker;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import com.harshana.wposandroiposapp.Base.GlobalWait;
        import com.harshana.wposandroiposapp.DevArea.GlobalData;
        import com.harshana.wposandroiposapp.Utilities.Formatter;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;

public class CManualEntryActivity extends AppCompatActivity {

    private NumberPicker dtYearPicker;
    private NumberPicker dtMonthPicker;

    private TextView btnCancel,btnProceed,txtPan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmanual_entry); // Replace "your_layout" with the actual layout file name

        // Find the NumberPicker by its ID
        dtYearPicker = findViewById(R.id.dtYearPicker);


        btnCancel = findViewById(R.id.btnCancel);
        btnProceed = findViewById(R.id.btnProceed);
        txtPan = findViewById(R.id.Setpassword);


        // Configure the NumberPicker as needed
        dtYearPicker.setMinValue(1900); // Set the minimum value
        dtYearPicker.setMaxValue(2099); // Set the maximum value
        dtYearPicker.setValue(2023);    // Set the initial value
        dtYearPicker.setWrapSelectorWheel(true); // Enable wrapping of values

        // Add a listener to handle value changes if needed
        dtYearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // Handle value change
            }
        });



        // Find the NumberPicker by its ID
        dtMonthPicker = findViewById(R.id.dtMonthPicker);

        // Configure the NumberPicker for months
        String[] monthNames = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        dtMonthPicker.setMinValue(1); // Minimum value (January)
        dtMonthPicker.setMaxValue(12); // Maximum value (December)
        dtMonthPicker.setDisplayedValues(monthNames); // Display month names
        dtMonthPicker.setWrapSelectorWheel(true); // Enable wrapping of values (optional)

        // Add a listener to handle month selection
        dtMonthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // Handle month selection
                String selectedMonth = monthNames[newVal - 1]; // Adjust for 0-based index
                // Do something with the selectedMonth, such as displaying it or storing it.
            }
        });


        btnProceed.setOnClickListener(clickListener);
        btnCancel.setOnClickListener(clickListener);


    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btnCancel == v) {
                GlobalData.globalTransactionAmount = 0;
                GlobalWait.setLastOperCancelled(true);
                setResult(RESULT_CANCELED);
                finish();
            } else if (btnProceed == v) {
                //validate the data
                btnProceed.setEnabled(false);
                btnProceed.setClickable(false);
                int year = dtYearPicker.getValue();
                String strYear = Formatter.fillInFront("0", String.valueOf(year), 2);

                int month = dtMonthPicker.getValue();
                String strMonth = Formatter.fillInFront("0", String.valueOf(month), 2);

                String pan = txtPan.getText().toString();
                if (pan == null || pan.equals("")) {
                    showToast("Please enter a valid PAN");
                    btnProceed.setEnabled(true);
                    btnProceed.setClickable(true);
                    return;
                } else if (pan.length() < 8) {
                    showToast("A PAN should be at least 8 numbers");
                    btnProceed.setEnabled(true);
                    btnProceed.setClickable(true);
                    return;
                }

                GlobalData.manualKeyExpDate = strYear + strMonth;
                if (!validateExpDate(GlobalData.manualKeyExpDate)) {
                    showToast("Expired Card");
                    btnProceed.setEnabled(true);
                    btnProceed.setClickable(true);
                    return;
                }

                //generate a new transaction and proceed
                GlobalData.isManualKeyIn = true;
                GlobalData.manualKeyPan = pan;
                try {
//                    BankCard bankCard = new BankCard(ManualKeyEntry.this);
//                    bankCard.breakOffCommand();
                } catch (Exception ex) {}
                setResult(RESULT_OK);
                finish();
            }
        }
    };

    private boolean validateExpDate(String expDate){
        String date = expDate.substring(2, 4) + "/" + expDate.substring(0, 2);

        try {
            Date expdate = new SimpleDateFormat("MM/yy").parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(expdate);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            expdate = c.getTime();
            if (expdate.after(new Date())) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }




    @Override
    public void onBackPressed() {
        return;
    }

    Toast showToastMessage;
    void showToast(String toastMessage) {
        if (showToastMessage != null) {
            showToastMessage.setText(toastMessage);
            showToastMessage.show();
        } else {
            showToastMessage = Toast.makeText(CManualEntryActivity.this,toastMessage,Toast.LENGTH_SHORT);
            showToastMessage.show();
        }
    }






}
