package com.rabelas.weathercurrentday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainMenu extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Toolbar toolbar;
    ConstraintLayout cl;
    //String[] mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(new MainMenuAdapter(this));

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.menu_row, R.id.textView, mainMenu);

        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("DELUBYOCATION");
        setSupportActionBar(toolbar);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(position){
            case 0: Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case 1: Intent j = new Intent(this, SafetyTips.class);
                startActivity(j);
                break;
            case 2: Intent k = new Intent(this, EvacCenterPage.class);
                startActivity(k);
                break;
        }
    }
}