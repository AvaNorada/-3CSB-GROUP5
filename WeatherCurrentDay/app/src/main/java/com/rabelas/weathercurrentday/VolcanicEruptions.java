package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class VolcanicEruptions extends AppCompatActivity {
    ConstraintLayout cl;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volcanic_eruptions);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Volcanic Eruption");
        setSupportActionBar(toolbar);
    }

    public void ve_B(View v){
        Intent i = new Intent(this, VE_B.class);
        startActivity(i);
    }
    public void ve_D(View v){
        Intent i = new Intent(this, VE_D.class);
        startActivity(i);
    }
    public void ve_A(View v){
        Intent i = new Intent(this, VE_A.class);
        startActivity(i);
    }
}