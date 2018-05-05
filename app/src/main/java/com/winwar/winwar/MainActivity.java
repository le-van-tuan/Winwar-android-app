package com.winwar.winwar;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.winwar.winwar.adapter.SpinnerAdapter;
import com.winwar.winwar.attribute.AppConstant;
import com.winwar.winwar.attribute.LocaleAttributes;
import com.winwar.winwar.context.ApplicationContextHolder;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String[] spinnerName;
    private int[] spinnerImages;
    private Spinner mSpinner;
    private Button continueButton;
    private final String currentDeviceLanguage = Locale.getDefault().getLanguage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueButton = findViewById(R.id.continueButton);
        changeConfig();

        mSpinner = findViewById(R.id.spinner);
        spinnerName = new String[]{AppConstant.DEFAULT, AppConstant.VIETNAMESE, AppConstant.FRANCE, AppConstant.ENGLISH};
        spinnerImages = new int[]{
                R.drawable.flag_default,
                R.drawable.flag_vietnam,
                R.drawable.flag_france,
                R.drawable.flag_english
        };

        SpinnerAdapter mSpinnerAdapter = new SpinnerAdapter(MainActivity.this, spinnerImages, spinnerName);
        mSpinner.setAdapter(mSpinnerAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (spinnerName[i]){
                    case AppConstant.VIETNAMESE : changeLanguage(LocaleAttributes.VIETNAMESE_SCALE);
                    break;

                    case AppConstant.ENGLISH : changeLanguage(LocaleAttributes.ENGLISH_SCALE);
                    break;

                    case AppConstant.FRANCE : changeLanguage(LocaleAttributes.FRANCE_SCALE);
                    break;

                    case AppConstant.DEFAULT : changeLanguage(currentDeviceLanguage);
                    break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InstallActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }

    private void changeLanguage(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        this.getApplicationContext().getResources().updateConfiguration(config, this.getApplicationContext().getResources().getDisplayMetrics());

        changeConfig();
    }

    private void changeConfig(){
        Configuration conf = getResources().getConfiguration();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        ApplicationContextHolder.changeApplicationContext(conf, metrics, getAssets());
    }
}
