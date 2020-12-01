package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Typhoon extends AppCompatActivity {
    ConstraintLayout cl;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Typhoon");
        setSupportActionBar(toolbar);
    }

    public void typ_B(View v){
        Intent i = new Intent(this, Typ_B.class);
        startActivity(i);
    }
    public void typ_D(View v){
        Intent i = new Intent(this, Typ_D.class);
        startActivity(i);
    }
    public void typ_A(View v){
        Intent i = new Intent(this, Typ_A.class);
        startActivity(i);
    }
}