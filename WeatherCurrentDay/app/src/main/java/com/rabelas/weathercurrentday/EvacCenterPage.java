package com.rabelas.weathercurrentday;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class EvacCenterPage extends AppCompatActivity implements AdapterView.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener{
    CustomAdapter customAdapter;
    Toolbar toolbar;
    ConstraintLayout cl;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        ListView listView=findViewById(R.id.listView);

        customAdapter = new CustomAdapter(this);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(this);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Evacuation Centers");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String name = customAdapter.evacList.get(position).name;
        String toastll = "You selected " + customAdapter.evacList.get(position);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:0,0?q=" + name));
        Toast.makeText(getApplicationContext(), toastll, Toast.LENGTH_SHORT).show();
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