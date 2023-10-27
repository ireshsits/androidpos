package com.example.myapplication;


        import android.os.Bundle;
        import android.widget.NumberPicker;
        import androidx.appcompat.app.AppCompatActivity;

public class CManualEntryActivity extends AppCompatActivity {

    private NumberPicker dtYearPicker;
    private NumberPicker dtMonthPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmanual_entry); // Replace "your_layout" with the actual layout file name

        // Find the NumberPicker by its ID
        dtYearPicker = findViewById(R.id.dtYearPicker);

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





    }
}
