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

public class Home extends AppCompatActivity {

    private Button HerafeActBtn;
    private Button AboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //add
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //end add
        HerafeActBtn = (Button) findViewById(R.id.act_btn_herafe);

        AboutBtn = (Button) findViewById(R.id.about_btn);

        HerafeActBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActHerafe();
            }
        });

        AboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActAbout();
            }
        });
    }


    private void OpenActHerafe()
    {
        Intent HerafeAct = new Intent(this, Herafe.class);
        startActivity(HerafeAct);
    }

    private void OpenActAbout()
    {
        Intent AboutAct = new Intent(this, About.class);
        startActivity(AboutAct);
    }
}