package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SafetyTips extends AppCompatActivity {

    ConstraintLayout cl;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_tips);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("SAFETY TIPS and GUIDELINES");
        setSupportActionBar(toolbar);
    }

    public void eQuake(View v){
        Intent i = new Intent(this, Earthquake.class);
        startActivity(i);
    }
    public void tYP(View v){
        Intent i = new Intent(this, Typhoon.class);
        startActivity(i);
    }
    public void vErup(View v){
        Intent i = new Intent(this, VolcanicEruptions.class);
        startActivity(i);
    }
}