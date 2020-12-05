package com.rabelas.weathercurrentday;

<<<<<<< Updated upstream
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

=======
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
>>>>>>> Stashed changes
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

<<<<<<< Updated upstream
public class MainMenu extends AppCompatActivity {
    Toolbar toolbar;
    ConstraintLayout cl;
=======
import com.google.android.material.navigation.NavigationView;


public class MainMenu extends AppCompatActivity implements AdapterView.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ConstraintLayout cl;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("DELUBYOCATION");
        setSupportActionBar(toolbar);
<<<<<<< Updated upstream
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
=======
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        //toolbarNav = (Toolbar) findViewById(R.id.nav_toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(new MainMenuAdapter(this));
        listView.setOnItemClickListener(this);
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
>>>>>>> Stashed changes
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_settings:
                Intent intent = new Intent(MainMenu.this, Settings.class);
                startActivity(intent);
                break;
            case R.id.nav_about:
                Intent intent1 = new Intent(MainMenu.this, About.class);
                startActivity(intent1);
                break;
        }
        return true;
    }
}