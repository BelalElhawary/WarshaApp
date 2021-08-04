package com.santraf4.warsha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class SensorTools extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;
    private SensorEventListener gyroscopeEventListener;

    private int x,y,z;

    private TextView te;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_tools);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);


        te = (TextView) findViewById(R.id.test);
        if(gyroscopeSensor == null)
        {
            Toast.makeText(this, "هذا الجهاز لا يحتوي على Gyroscope Sensor", Toast.LENGTH_SHORT).show();
            finish();
        }


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                te.setText(String.valueOf(x) + "  " + String.valueOf(y) + "  " + String.valueOf(z));
            }
        }, 0, 1000);
        //timer.cancel();

        gyroscopeEventListener = new SensorEventListener(){
            @Override
            public void onSensorChanged(SensorEvent sensorEvent){


                x = (int)Math.toDegrees(sensorEvent.values[0]);
                y = (int)Math.toDegrees(sensorEvent.values[1]);
                z = (int)Math.toDegrees(sensorEvent.values[2]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i)
            {

            }
        };

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(gyroscopeEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(gyroscopeEventListener);
    }
}