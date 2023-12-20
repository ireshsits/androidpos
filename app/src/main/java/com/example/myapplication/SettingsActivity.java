package com.example.myapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        Fragment fragment =  new SettingsFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (savedInstanceState == null) {
            // Load the PreferenceFragment into the FrameLayout
            fragmentTransaction.add(R.id.settingsFragmentContainer,fragment,"settings_page");
            fragmentTransaction.commit();
        } else {
        fragment = getFragmentManager().findFragmentByTag("settings_page");
    }




        onSharedPreferenceChangeListener =  new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                showToast( "Setting Changed");
                try {
                    Log.e("MENU KEY", " : " + key);
                    if (key.equalsIgnoreCase("is_pre_auth_enable")) {
                        boolean val = Preferences.getInstance(SettingsActivity.this).getBoolean("is_pre_auth_enable");
                        Log.e("Setting Log ", "  :" + val);
                        Preferences.getInstance(SettingsActivity.this).saveBoolean(key, !val);
                    } else {

                      //  SettingsInterpreter.callSettingsChangedFunc(key, sharedPreferences.getBoolean(key, true));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }


    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = null;

    @Override
    protected void onResume() {
        super.onResume();
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    Toast showToastMessage;
    void showToast(String toastMessage) {
        if (showToastMessage != null) {
            showToastMessage.setText(toastMessage);
            showToastMessage.show();
        } else {
            showToastMessage = Toast.makeText(SettingsActivity.this,toastMessage,Toast.LENGTH_SHORT);
            showToastMessage.show();
        }
    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_page); // Load the XML layout
        }
    }
}

