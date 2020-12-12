package com.rabelas.weathercurrentday;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.rabelas.weathercurrentday.models.WebpageData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Eq_D extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    ConstraintLayout cl;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eq_d);

        cl = findViewById(R.id.cLayout);
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("DURING Earthquake");
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        final TextView bodyText= findViewById(R.id.webBody);
        //final TextView titleText= findViewById(R.id.webTitle);

        new Thread(new Runnable() {

            WebpageData data = new WebpageData();
            @Override
            public void run() {


                try {
                    Document Edoc =  Jsoup.connect("https://www.cofh.org/173/Before-During-and-After-an-Earthquake").get();
                    //Document Vdoc =  Jsoup.connect("https://coins.ph/blog/what-to-do-volcanic-eruption-tips/").get();
                    //Document Fdoc =  Jsoup.connect("http://people360.com.ph/what-to-do-before-during-and-after-a-typhoon").get();

                    Elements EText = Edoc.select("#divEditor69697407-c5dd-435d-8184-85e3d7c18d9e");
                    //Element VText = Vdoc.body();
                    //Elements VText = Vdoc.select("div.mk-single-content.clearfix");
                    //Elements FText = Fdoc.select("#content");

                    // Element bodyText = Edoc.body();
                    data.setPageBody(EText.text());



                    data.extractText("During","After");//this is dependent on the line above
                    // before.extractText("After:","https");//this is dependent on the line above
                    //before.extractText("During:","After:");//this is dependent on the line above
                    // before.extractText("Before:","During");//this is dependent on the line above




                    //before.extractText("THE ERUPTION","Stay safe");//this is dependent on the line above
                    //before.extractText("ERUPTION","AFTER");//this is dependent on the line above,
                    //before.extractText("EXPLOSION","DURING");//this is dependent on the line above,
                    //before.setPageTitle(EBdoc.title());


                } catch (IOException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {//Set to textview thru WebpageData object
                        // titleText.setText(before.getPageTitle());
                        bodyText.setText(data.getPageBody());
                    }
                });
            }
        }).start();
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