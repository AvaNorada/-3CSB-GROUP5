package com.rabelas.weathercurrentday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

<<<<<<< Updated upstream
public class SafetyTips extends AppCompatActivity {

    ConstraintLayout cl;
=======
import com.google.android.material.navigation.NavigationView;

public class SafetyTips extends AppCompatActivity implements AdapterView.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener{
>>>>>>> Stashed changes
    Toolbar toolbar;
    ConstraintLayout cl;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_tips);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("SAFETY TIPS AND GUIDELINES");
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer((GravityCompat.START));
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                Intent intent = new Intent(this, MainMenu.class);
                startActivity(intent);
                break;
            case R.id.nav_settings:
                Intent intent1 = new Intent(this, Settings.class);
                startActivity(intent1);
                break;
            case R.id.nav_about:
                Intent intent2 = new Intent(this, About.class);
                startActivity(intent2);
                break;
        }
        return true;
    }
}