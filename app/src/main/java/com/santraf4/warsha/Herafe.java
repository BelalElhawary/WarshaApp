package com.santraf4.warsha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Herafe extends AppCompatActivity {

    private Button ActShapeBtn;
    private Button ActMaslopBtn;
    private Button ActCircleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herafe);

        ActShapeBtn = (Button) findViewById(R.id.act_btn_shape);
        ActMaslopBtn = (Button) findViewById(R.id.act_btn_maslop);
        ActCircleBtn = (Button) findViewById(R.id.act_btn_circle);

        ActMaslopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActMaslop();
            }
        });

        ActShapeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActShape();
            }
        });

        ActCircleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActCircle();
            }
        });
    }

    private void OpenActShape()
    {
        Intent SahpesAct = new Intent(this, Shapes.class);
        startActivity(SahpesAct);
    }

    private void OpenActMaslop()
    {
        Intent MaslopAct = new Intent(this, Maslop.class);
        startActivity(MaslopAct);
    }

    private void OpenActCircle()
    {
        Intent CircleAct = new Intent(this, CircleCut.class);
        startActivity(CircleAct);
    }
}