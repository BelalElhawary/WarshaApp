package com.santraf4.warsha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Shapes extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private ImageView ShapeImage;
    private TextView ShapeOutVal;
    private EditText ShapeEditText1;
    private EditText ShapeEditText2;
    private EditText ShapeEditText3;
    private Button ShapeAns;

    private Spinner ShapeSpin;
    private String ShapeValue;
    private float input1 = 0;
    private float input2 = 0;
    private float input3 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);
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

        ShapeImage = (ImageView) findViewById(R.id.shape_image);
        ShapeOutVal = (TextView) findViewById(R.id.shape_outval);
        ShapeAns = (Button) findViewById(R.id.shape_ans);
        ShapeEditText1 = (EditText) findViewById(R.id.shape_input1);
        ShapeEditText2 = (EditText) findViewById(R.id.shape_input2);
        ShapeEditText3 = (EditText) findViewById(R.id.shape_input3);


        ShapeSpin = (Spinner) findViewById(R.id.shape_spin);
        ArrayAdapter<String> ShapeTextValue = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.shapes_name));
        ShapeTextValue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ShapeSpin.setAdapter(ShapeTextValue);
        ShapeSpin.setOnItemSelectedListener(this);

        ShapeAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreSetValues();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String inputV = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), inputV, Toast.LENGTH_SHORT).show();
        ShapeValue = inputV;
        if (ShapeValue.equals("مساحة المربع")) {
            ShapeImage.setImageResource(R.drawable.cube);
        } else if (ShapeValue.equals("مساحة المثلث")) {
            ShapeImage.setImageResource(R.drawable.triangle_ms);
        } else if (ShapeValue.equals("مساحة الدائرة")) {
            ShapeImage.setImageResource(R.drawable.circle);
        } else if (ShapeValue.equals("محيط المربع")) {
            ShapeImage.setImageResource(R.drawable.cube);
        } else if (ShapeValue.equals("محيط المثلث")) {
            ShapeImage.setImageResource(R.drawable.triangle_mh);
        } else if (ShapeValue.equals("محيط الدائرة")) {
            ShapeImage.setImageResource(R.drawable.circle);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void PreSetValues() {
        if (ShapeEditText1.getText().toString().equals("") && ShapeEditText2.getText().toString().equals(""))
            return;

        if (!ShapeEditText1.getText().toString().equals(""))
            input1 = Float.parseFloat(ShapeEditText1.getText().toString());
        if (!ShapeEditText2.getText().toString().equals(""))
            input2 = Float.parseFloat(ShapeEditText2.getText().toString());
        if (!ShapeEditText3.getText().toString().equals(""))
            input3 = Float.parseFloat(ShapeEditText3.getText().toString());


        if (ShapeValue.equals("مساحة المربع")) {
            Cube("مساحة");
        } else if (ShapeValue.equals("محيط المربع")) {
            Cube("محيط");
        }

        if (ShapeValue.equals("مساحة المثلث")) {
            Triangle("مساحة");
        } else if (ShapeValue.equals("محيط المثلث")) {
            Triangle("محيط");
        }

        if (ShapeValue.equals("مساحة الدائرة")) {
            Circle("مساحة");
        } else if (ShapeValue.equals("محيط الدائرة")) {
            Circle("محيط");
        }
    }

    private void Cube(String value)
    {
        if(input1 <= 0)
            return;
        float outval = 0;
        String dubg = "";
        if(value.equals("مساحة"))
        {
            outval = input1*input1;
            dubg = ("مساحة المربع = ") + Float.toString(outval);
        }else if(value.equals("محيط"))
        {
            outval = 4 * input1;
            dubg = ("محيط المربع = ") + Float.toString(outval);
        }
        ShapeOutVal.setText(dubg);
    }

    private void Circle(String value)
    {
        if(input1 <= 0)
            return;
        float outval = 0;
        String dubg = "";
        float haf = input1 / 2;
        if(value.equals("مساحة"))
        {
            outval =(float) (3.14 * (Math.pow(haf, 2)));
            dubg = ("مساحة الدائرة = ") + Float.toString(outval);

        }else if(value.equals("محيط"))
        {
            outval = (float) (2 * 3.14 * haf);
            dubg = ("محيط الدائرة = ") + Float.toString(outval);

        }
        ShapeOutVal.setText(dubg);
    }

    private void Triangle(String value)
    {

        float outval = 0;
        String dubg = "";
        if(value.equals("مساحة"))
        {
            if(input1 <= 0 || input2 <= 0)
                return;
            outval = (float) (input1 /2) * input2;
            dubg = ("مساحة المثلث = ") + Float.toString(outval);

        }else if(value.equals("محيط"))
        {
            if(input1 <= 0 || input2 <= 0 || input3 <= 0)
                return;
            outval = (float) input1 + input2 + input3;
            dubg = ("محيط المثلث = ") + Float.toString(outval);

        }
        ShapeOutVal.setText(dubg);
    }
}