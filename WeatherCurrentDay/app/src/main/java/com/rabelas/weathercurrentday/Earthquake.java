package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Earthquake extends AppCompatActivity {
    ConstraintLayout cl;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Earthquake");
        setSupportActionBar(toolbar);
    }

    public void eq_B(View v){
        Intent i = new Intent(this, Eq_B.class);
        startActivity(i);
    }
    public void eq_D(View v){
        Intent i = new Intent(this, Eq_D.class);
        startActivity(i);
    }
    public void eq_A(View v){
        Intent i = new Intent(this, Eq_A.class);
        startActivity(i);
    }
}