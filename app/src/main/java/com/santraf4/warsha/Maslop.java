package com.santraf4.warsha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class Maslop extends AppCompatActivity {

    private TextView OutVal;
    private EditText EditText1;
    private EditText EditText2;
    private EditText EditText3;
    private Button Enter;

    private float input1;
    private float input2;
    private float input3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maslop);

        OutVal = (TextView) findViewById(R.id.maslop_outval);
        Enter = (Button) findViewById(R.id.maslop_enter);
        EditText1 = (EditText) findViewById(R.id.maslop_input1);
        EditText2 = (EditText) findViewById(R.id.maslop_input2);
        EditText3 = (EditText) findViewById(R.id.maslop_input3);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = Float.parseFloat(EditText1.getText().toString());
                input2 = Float.parseFloat(EditText2.getText().toString());
                input3 = Float.parseFloat(EditText3.getText().toString());
                GetMaslop();
            }
        });
    }

    private void GetMaslop()
    {
        float val = (input2 - input1) / 2;
        float val2 = (float) (Math.sqrt(Math.pow(val, 2) + Math.pow(input3, 2)));
        float out = (float) Math.toDegrees(Math.asin(val / val2));
        OutVal.setText("درجة" + String.valueOf(out) + "قياس الزاوية");
    }
}