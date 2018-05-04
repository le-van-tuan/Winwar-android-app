package com.winwar.winwar;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.winwar.winwar.adapter.CustomAdapter;
import com.winwar.winwar.attribute.LocaleAttributes;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String[] spinnerName;
    int[] spinnerImages;
    Spinner mSpinner;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueButton = findViewById(R.id.continueButton);

        mSpinner = findViewById(R.id.spinner);
        spinnerName = new String[]{"Choose your language", "Vietnamese", "France", "English"};
        spinnerImages = new int[]{
                R.drawable.flag_default,
                R.drawable.flag_vietnam,
                R.drawable.flag_france,
                R.drawable.flag_english
        };

        CustomAdapter mCustomAdapter = new CustomAdapter(MainActivity.this, spinnerImages, spinnerName);
        mSpinner.setAdapter(mCustomAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinnerName[i].equalsIgnoreCase("Vietnamese")){
                    changeLanguage(LocaleAttributes.VIETNAME_SCALE);
                }if(spinnerName[i].equalsIgnoreCase("France")){
                    changeLanguage(LocaleAttributes.FRANCE_SCALE);
                }if (spinnerName[i].equalsIgnoreCase("English")){
                    changeLanguage(LocaleAttributes.DEFAULT_SCALE);
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
    }
}
