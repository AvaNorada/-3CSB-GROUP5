package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {
    Toolbar toolbar;
    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("DELUBYOCATION");
        setSupportActionBar(toolbar);
    }


    public void showWR(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void showST(View v){
        Intent i = new Intent(this, SafetyTips.class);
        startActivity(i);
    }
    public void showEC(View v){
        Intent i = new Intent(this, EvacCenter.class);
        startActivity(i);
    }
}