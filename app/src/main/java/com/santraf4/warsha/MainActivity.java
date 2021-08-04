package com.santraf4.warsha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private Button GetIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetIn = (Button) findViewById(R.id.welcome_GetInBtn);
        GetIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenHomeAct();
            }
        });


    }

    private void OpenHomeAct()
    {
        Intent HomeAct = new Intent(this, Home.class);
        startActivity(HomeAct);
    }
}