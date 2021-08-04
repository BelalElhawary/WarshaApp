package com.santraf4.warsha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.santraf4.warsha.views.CustomView;

public class CircleCut extends AppCompatActivity {

    public ImageView CircleImage;
    public TextView outVal;
    public EditText Input1;
    public EditText Input2;
    public Button enter;

    private float input1;
    private float input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_cut);
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

        CircleImage = (ImageView) findViewById(R.id.circle_image);
        outVal = (TextView) findViewById(R.id.circle_outval);
        Input1 = (EditText) findViewById(R.id.circle_input1);
        Input2 = (EditText) findViewById(R.id.circle_input2);
        enter = (Button) findViewById(R.id.circle_ans);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetCirclePolygon();
            }
        });
    }

    private void GetCirclePolygon()
    {
        if(!Input1.getText().toString().equals("") && !Input2.getText().toString().equals(""))
        {
            input1 = Float.parseFloat(Input1.getText().toString());
            input2 = Float.parseFloat(Input2.getText().toString());
        }else {
            return;
        }

        if(input1 <= 0 && input2 <= 0)
            return;
        float test = 180 / input1;
        float out = (float) Math.sin(test) * input2;
        outVal.setText("ملى متر" + String.valueOf(out) + "طول الضلع الواحد");
    }
}