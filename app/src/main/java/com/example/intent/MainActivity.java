package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.SettingInjectorService;
import android.media.audiofx.BassBoost;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.ContentHandler;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    TextView editPhone;
    Button  btnPhone, btnActivity, btnBrowser,btnWifi,btnApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPhone = (TextView) findViewById(R.id.editPhone);
        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnActivity = (Button) findViewById(R.id.btnActivity);
        btnBrowser = (Button) findViewById(R.id.btnBrowser);
        btnWifi = (Button) findViewById(R.id.btnWifi);
        btnApps = (Button) findViewById(R.id.btnApps);

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +
                        editPhone.getText().toString()));
                startActivity(intent);
            }
        });

        btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);


            }
        });

        //Click on the Button "Other Activity"
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent= new Intent( view.getContext() ,OtherActivity.class );
                startActivity(intent);
            }
        });

        btnApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
                startActivity(intent);
            }
        });
        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.google.fr./");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
    }